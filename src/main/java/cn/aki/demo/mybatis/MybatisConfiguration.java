package cn.aki.demo.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.aki.demo.dao")
public class MybatisConfiguration {

	/**
	 * 拦截器自动注入
	 */
	@Bean
	public MybatisInterceptor mybatisInterceptor() {
		return new MybatisInterceptor();
	}
}
