package com.login.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.login.demo.model.User;
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
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> findUsers(){
		return demoService.findUsers();
	}
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	public User findUser(@PathVariable(value="id")Long id) {
		return demoService.findUser(id);
	}
	@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
	public void removeUser(@PathVariable(value="id")Long id,HttpServletResponse response) {
		demoService.removeUser(id);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public Map<String,Object> saveUser(@RequestBody User user,HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		demoService.saveOrUpdateUser(user);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("state", "success");
		return resultMap;
	}
	@RequestMapping(value="/users/{id}",method=RequestMethod.POST)
	public Map<String,Object> updateUser(@PathVariable(value="id")Long id,@RequestBody User user) {
		user.setId(id);
		demoService.saveOrUpdateUser(user);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("state", "success");
		return resultMap;
	}
	
}
