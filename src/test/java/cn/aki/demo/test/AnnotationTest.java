package cn.aki.demo.test;

import cn.aki.demo.annotation.*;
import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * Created by Administrator on 2017/6/12.
 */
public class AnnotationTest {

	@Test
	public void implementTest(){
		test(ParentInterfaceImpl.class);
	}

	@Test
	public void interfaceExtendTest(){
		test(IChildInterface.class);
 	}

 	@Test
 	public void classExtendTest(){
		test(ChildClass.class);
	}

 	@Test
 	public void selfTest(){
		test(IParentInterface.class);
	}

	@Test
	public void springTest(){
 		// springMVC解析@RequestMapping时使用,RequestMappingHandlerMapping.createRequestMappingInfo
		// Class实现AnnotatedElement接口
		MyAnnotation annotation = AnnotatedElementUtils.findMergedAnnotation(ParentInterfaceImpl.class, MyAnnotation.class);
		System.err.println(annotation.value());
	}

 	private void test(Class<?> clazz){
		boolean result = clazz.isAnnotationPresent(MyAnnotation.class);
		System.err.println(result);
	}
}
