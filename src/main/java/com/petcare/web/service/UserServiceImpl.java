package com.petcare.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;
import com.petcare.web.mapper.UserMapperImpl;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapperImpl mapper;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return mapper.login(dto);
	}

}
