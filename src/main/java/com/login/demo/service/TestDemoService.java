package com.login.demo.service;

import java.util.List;
import java.util.Map;

import com.login.demo.model.User;

public interface TestDemoService {

	public Map<String,Object> login();
	
	public List<User> findUsers();
	
	public User findUser(Long id);
	
	public void removeUser(Long id);
	
	public void saveOrUpdateUser(User user);
}
