package cn.aki.demo.mybatis;

import java.util.List;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;

public class MySqlSource implements SqlSource{
	private SqlSource sqlSource;
	private Configuration configuration;
	private List<ParameterMapping> parameterMappings;
	public static final String PROPERTY_LIMIT = "limit";
	
	public MySqlSource(SqlSource sqlSource, Configuration configuration) {
		this.sqlSource = sqlSource;
		this.configuration = configuration;
	}
	@Override
	public BoundSql getBoundSql(Object parameterObject) {
		BoundSql rawBoundSql = sqlSource.getBoundSql(parameterObject);
		MetaObject metaObject = SystemMetaObject.forObject(rawBoundSql);
		String sql = rawBoundSql.getSql();
		metaObject.setValue("sql", sql + " limit ?");
		if(parameterMappings == null){
			// 会取到原始parameterMappings的引用
			parameterMappings = rawBoundSql.getParameterMappings();
			parameterMappings.add(new ParameterMapping.Builder(configuration, PROPERTY_LIMIT, Integer.class).build());
		}
		metaObject.setValue("parameterMappings", parameterMappings);
		return rawBoundSql;
	}

}
