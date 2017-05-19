package cn.aki.demo.proxy;
/**
 * 拦截接口
 * @author Administrator
 *
 */
public interface Interceptor {
	Object intercept(Invocation invocation);
}
