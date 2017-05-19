package cn.aki.demo.mybatis;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 必须要有@Intercepts，允许拦截的类Executor、ParameterHandler、ResultSetHandler、StatementHandler
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }) })
public class MybatisInterceptor implements Interceptor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public Object intercept(Invocation invocation) throws Throwable {
		log.debug("intercept,target<{}>,method<{}>", invocation.getTarget().toString(), invocation.getMethod());
		final int limit = 100;
		MappedStatement statement = (MappedStatement) invocation.getArgs()[0];// 定义的sql
		MetaObject statementMeta = SystemMetaObject.forObject(statement);
		Object param = invocation.getArgs()[1];// 原始参数
		Map<String, Object> paramMap = processParameter(statement, param, statement.getBoundSql(param));
		// 在sqlSource对象中修改sql
		statementMeta.setValue("sqlSource", new MySqlSource(statement.getSqlSource(), statement.getConfiguration()));
		paramMap.put(MySqlSource.PROPERTY_LIMIT, limit);
		invocation.getArgs()[1] = paramMap; // 参数替换
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		log.debug("plugin,target:{}", target.toString());
		// 返回代理类才会调用
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		log.debug("setProperties");
	}

	/**
	 * 参数类型转成map
	 * @param ms
	 * @param parameterObject
	 * @param boundSql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> processParameter(MappedStatement ms, Object parameterObject, BoundSql boundSql) {
        Map<String, Object> paramMap = null;
        if (parameterObject == null) {
            paramMap = new HashMap<String, Object>();
        } else if (parameterObject instanceof Map) {
            //解决不可变Map的情况
            paramMap = new HashMap<String, Object>();
            paramMap.putAll((Map<? extends String, ? extends Object>) parameterObject);
        } else {
            paramMap = new HashMap<String, Object>();
            //动态sql时的判断条件不会出现在ParameterMapping中，但是必须有，所以这里需要收集所有的getter属性
            //TypeHandlerRegistry可以直接处理的会作为一个直接使用的对象进行处理
            boolean hasTypeHandler = ms.getConfiguration().getTypeHandlerRegistry().hasTypeHandler(parameterObject.getClass());
            MetaObject metaObject = SystemMetaObject.forObject(parameterObject);
            if (!hasTypeHandler) {
                for (String name : metaObject.getGetterNames()) {
                    paramMap.put(name, metaObject.getValue(name));
                }
            }
            //下面这段方法，主要解决一个常见类型的参数时的问题
            if (boundSql.getParameterMappings() != null && boundSql.getParameterMappings().size() > 0) {
                for (ParameterMapping parameterMapping : boundSql.getParameterMappings()) {
                    String name = parameterMapping.getProperty();
                    if (paramMap.get(name) == null) {
                        if (hasTypeHandler || parameterMapping.getJavaType().equals(parameterObject.getClass())) {
                            paramMap.put(name, parameterObject);
                            break;
                        }
                    }
                }
            }
        }
        return paramMap;
    }
}
