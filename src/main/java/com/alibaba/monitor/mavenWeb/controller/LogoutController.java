package com.alibaba.monitor.mavenWeb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhuohaidi
 */
@Controller
public class LogoutController {
	
	@RequestMapping(value = "/logout.html",method=RequestMethod.GET)
	public String logout (HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:home";
	}
}
