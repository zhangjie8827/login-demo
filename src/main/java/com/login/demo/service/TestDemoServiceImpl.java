package com.login.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.demo.dao.UserDao;
import com.login.demo.model.User;

@Service
public class TestDemoServiceImpl implements TestDemoService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> login() {
		Map<String,Object> resutMap = new HashMap<String,Object>();
		resutMap.put("state", "success");
		return resutMap;
	}

	@Override
	public List<User> findUsers() {
		return userDao.findUsers();
	}

	@Override
	public User findUser(Long id) {
		return userDao.findUser(id);
	}

	@Override
	public void removeUser(Long id) {
		userDao.removeUser(id);
	}

	@Override
	public void saveOrUpdateUser(User user) {
		userDao.saveOrUpdateUser(user);
	}
	
}
