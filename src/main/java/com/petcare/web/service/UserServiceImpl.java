package com.petcare.web.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.CustomerVO;
import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;
import com.petcare.web.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public CustomerVO login(LoginDTO dto) throws Exception {
		return mapper.login(dto);
	}
	
	@Override
	public void keepLogin(String userid,String sessionId, Date next) throws Exception{
		mapper.keepLogin(userid,sessionId,next);
	}
	
	@Override
	public CustomerVO checkLoginBefore(String value) {
		return mapper.checkUserWithSessionKey(value);
	}
}
