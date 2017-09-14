package cn.aki.demo.urlrewrite;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlRewriteConfiguration {

	/**
	 * 注册url rewrite filter
	 * /rewrite-status查询配置详情
	 */
	@Bean
	FilterRegistrationBean urlRewriteFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new MyUrlRewriteFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}
}
