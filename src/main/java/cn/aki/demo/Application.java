package cn.aki.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.aki.demo.dao.TestObjectMapper;
import cn.aki.demo.entity.TestObject;

public class Application {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring.xml");
		TestObjectMapper mapper = context.getBean(TestObjectMapper.class);
		TestObject obj = mapper.selectByPrimaryKey(1L);
		System.err.println(obj);
	}

}
