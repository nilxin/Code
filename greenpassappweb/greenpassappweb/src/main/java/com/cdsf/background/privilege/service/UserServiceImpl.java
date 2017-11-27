package com.cdsf.background.privilege.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsf.background.privilege.domain.User;
import com.cdsf.background.privilege.mapper.UserMapper;
import com.cdsf.configure.AbstractService;

@Service
public class UserServiceImpl extends AbstractService implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> checkLogin(Map<String, Object> map) {
		return userMapper.queryExistUser(map);
	}

}
