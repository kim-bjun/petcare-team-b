package com.petcare.web.service;

import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;

public interface UserService {

	public UserVO login(LoginDTO dto) throws Exception;
}
