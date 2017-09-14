package cn.aki.demo.urlrewrite;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * url重构过滤器
 */
public class MyUrlRewriteFilter extends UrlRewriteFilter {

	private static final String CONFIG_LOCATION = "urlrewrite.xml";

	//Inject the Resource from the given location
	private Resource resource;

	public MyUrlRewriteFilter() {
		resource = new ClassPathResource(CONFIG_LOCATION);
	}

	//Override the loadUrlRewriter method, and write your own implementation
	@Override
	protected void loadUrlRewriter(FilterConfig filterConfig) throws ServletException {
		try {
			//Create a UrlRewrite Conf object with the injected resource
			Conf conf = new Conf(filterConfig.getServletContext(), resource.getInputStream(),
					resource.getFilename(), "");
			checkConf(conf);
		} catch (IOException ex) {
			throw new ServletException("Unable to load URL rewrite configuration file from " + CONFIG_LOCATION, ex);
		}
	}
}