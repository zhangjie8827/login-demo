package com.login.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.login.demo.dao.UserDao;
import com.login.demo.model.User;
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<User> findUsers() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String sql = "select * from sys_user";
		return namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User findUser(Long id) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String sql = "select * from sys_user where id=:id";
		paramMap.put("id", id);
		List<User> list = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<User>(User.class));
		if(list != null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void removeUser(Long id) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String sql = "delete from sys_user where id=:id";
		paramMap.put("id", id);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}

	@Override
	public void saveOrUpdateUser(User user) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		String sql = "";
		if(user.getId() != null) {
			sql = "update sys_user set username=:username,fullName=:fullName,password=:password,age=:age,sex=:sex where id=:id";
			paramMap.put("id", user.getId());
		}else {
			sql = "insert into sys_user (username,fullName,password,age,sex) values (:username,:fullName,:password,:age,:sex)";
		}
		paramMap.put("username", user.getUsername());
		paramMap.put("fullName", user.getFullName());
		paramMap.put("password", user.getPassword());
		paramMap.put("age", user.getAge());
		paramMap.put("sex", user.getSex());
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
}
