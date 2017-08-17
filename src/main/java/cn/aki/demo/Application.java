package cn.aki.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:spring/spring-mybatis.xml") // spring xml配置文件
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}