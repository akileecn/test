package cn.aki.demo;

import cn.aki.demo.controller.SpringBootController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.aki.demo.dao.TestObjectMapper;
import cn.aki.demo.entity.TestObject;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration // spring boot
@ImportResource("spring/spring-mybatis.xml") // spring xml配置文件
@PropertySource("classpath:config.properties") // properties配置文件
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableDiscoveryClient
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		SpringApplication app = new SpringApplication(Application.class);
//		app.run(args);
	}

}
