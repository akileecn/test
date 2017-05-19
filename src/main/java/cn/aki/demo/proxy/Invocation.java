package cn.aki.demo.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 反射调用需要的参数封装
 * @author Administrator
 *
 */
public class Invocation {
	private Method method;
	private Object[] args;
	private Object target;
	
	public Invocation(Method method, Object[] args, Object target) {
		super();
		this.method = method;
		this.args = args;
		this.target = target;
	}

	/**
	 * 反射调用方法
	 * @return
	 */
	public Object proceed(){
		try {
			return method.invoke(target, args);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	
}
