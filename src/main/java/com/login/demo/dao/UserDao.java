package com.login.demo.dao;

import java.util.List;

import com.login.demo.model.User;

public interface UserDao {

	public List<User> findUsers();
	
	public User findUser(Long id);
	
	public void removeUser(Long id);
	
	public void saveOrUpdateUser(User user);
	
}
