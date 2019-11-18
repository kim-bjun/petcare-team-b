package com.petcare.web.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;

@Repository
public class UserMapperImpl implements UserMapper {
	
	@Autowired
	private SqlSession session;
	
	private static String namespace="com.petcare.web.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace+".login",dto);
	}

}
