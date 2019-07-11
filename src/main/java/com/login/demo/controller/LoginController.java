package com.login.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.login.demo.service.TestDemoService;

@RestController
@RequestMapping(value="/api")
public class LoginController {
	
	@Autowired
	private TestDemoService demoService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Map<String,Object> login() {
		return demoService.login();
	}
	
}
