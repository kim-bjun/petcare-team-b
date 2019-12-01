package com.petcare.web.service;

import java.util.Date;

import com.petcare.web.domains.CustomerVO;
import com.petcare.web.domains.LoginDTO;

public interface UserService {

	public CustomerVO login(LoginDTO dto) throws Exception;
	public void keepLogin(String userid,String sessionId, Date next) throws Exception;
	public CustomerVO checkLoginBefore(String value);
}
