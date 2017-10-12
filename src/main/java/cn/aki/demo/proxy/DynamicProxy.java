package cn.aki.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aki.demo.entity.TestObject;

public class DynamicProxy implements InvocationHandler{
	private static final Logger log = LoggerFactory.getLogger(DynamicProxy.class);
	private Object target;
	private Interceptor interceptor;
	
	private DynamicProxy(Object target, Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.debug("invoke method:{}", method);
		Invocation invocation = new Invocation(method, args, target);
		if(interceptor != null){
			return interceptor.intercept(invocation);
		}else{
			return invocation.proceed();
		}
	}
	
	public static Object wrap(Object target, Interceptor interceptor){
		Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new DynamicProxy(target, interceptor));
		return obj;
	}
	
	public static void main(String[] args) {
		TestObject obj = new TestObject();
		obj.setTextValue("123");
		IText proxy = (IText)DynamicProxy.wrap(obj, new HelloInterceptor());
		String str = proxy.getText();
		System.err.println(str);
	}

}
