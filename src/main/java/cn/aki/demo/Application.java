package cn.aki.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {
	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		// 自定义实例名称生成器，防止类名冲突
		CustomBeanNameGenerator generator = new CustomBeanNameGenerator();
		generator.addBasePackages("cn.aki.demo");
		new SpringApplicationBuilder(Application.class)
				.beanNameGenerator(generator)
//				.build()
				.run(args);
	}

}