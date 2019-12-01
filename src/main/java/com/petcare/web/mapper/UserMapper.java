package com.petcare.web.mapper;

import java.util.Date;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.petcare.web.domains.CustomerVO;
import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;

@Mapper

public interface UserMapper {

	public CustomerVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(@Param("user_id") String userid,@Param("sessionId") String sessionId,@Param("next") Date next);
	
	public CustomerVO checkUserWithSessionKey(String value);
}
