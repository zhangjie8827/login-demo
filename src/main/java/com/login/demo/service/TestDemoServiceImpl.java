package com.login.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TestDemoServiceImpl implements TestDemoService{

	@Override
	public Map<String, Object> login() {
		Map<String,Object> resutMap = new HashMap<String,Object>();
		resutMap.put("state", "success");
		return resutMap;
	}
	
}
