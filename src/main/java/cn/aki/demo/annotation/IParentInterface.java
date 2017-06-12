package cn.aki.demo.annotation;

import java.lang.annotation.Inherited;

/**
 * Created by Administrator on 2017/6/12.
 */
@MyAnnotation("interface")
public interface IParentInterface {
	@MyAnnotation("interface method")
	String anyMethod();
}
