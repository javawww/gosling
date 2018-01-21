package com.gosling.controller.index;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	/***静态链接*/
	public static final String LOGIN = "login.html";//列表页面
	
	
	@RequestMapping(value = IndexController.LOGIN,method = RequestMethod.GET)
	public String login(HttpServletRequest request,Map<String, Object> dataMap) {
		
		return "index/login";
	}
}
