package com.gosling.controller.index;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	/***静态链接*/
	public static final String LOGIN = "login.html";//登陆
	public static final String INDEX = "index.html";//首页
	
	
	/**
	 * 登陆
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = IndexController.LOGIN,method = RequestMethod.GET)
	public String login(HttpServletRequest request,Map<String, Object> dataMap) {
		
		return "index/login";
	}
	
	/**
	 * 首页
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = IndexController.INDEX,method = RequestMethod.GET)
	public String index(HttpServletRequest request,Map<String, Object> dataMap) {
		
		return "index/index";
	}
	
}
