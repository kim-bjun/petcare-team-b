package com.petcare.web.mapper;

import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;

public interface UserMapper {

	public UserVO login(LoginDTO dto) throws Exception;
}
