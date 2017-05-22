package cn.aki.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/22.
 */
@Controller
@RequestMapping("/boot")
public class SpringBootController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		return "hello world 3";
	}

}
