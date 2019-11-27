package com.petcare.web.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;

public interface UserMapper {

	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(@Param("userid") String userid,@Param("sessionId") String sessionId,@Param("next") Date next);
	
	public UserVO checkUserWithSessionKey(String value);
}
