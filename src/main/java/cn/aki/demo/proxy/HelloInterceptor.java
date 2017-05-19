package cn.aki.demo.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloInterceptor implements Interceptor{
	private static final Logger log = LoggerFactory.getLogger(HelloInterceptor.class);
	public Object intercept(Invocation invocation) {
		log.debug("hello {} {}", invocation.getTarget(), invocation.getMethod());
		return invocation.proceed();
	}

}
