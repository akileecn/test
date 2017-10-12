package cn.aki.demo;

import com.btmatthews.springboot.memcached.EnableMemcached;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.aki.demo.dao")
@EnableMemcached // 与mybatis插件不同
public class DemoConfiguration {

	//	@Bean
	public CorsFilter corsFilter() {
		return new CorsFilter();
	}
}
