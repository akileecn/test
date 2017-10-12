package cn.aki.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/22.
 */
@RestController
@RequestMapping("/")
//@CrossOrigin // spring自带的允许跨域请求
public class SpringBootController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello world 3";
	}

}
