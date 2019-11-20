package com.petcare.web.mapper;

import java.util.Map;

import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;

public interface UserMapper {

	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(Map<String,Object> paramMap);
	
	public UserVO checkUserWithSessionKey(String value);
}
