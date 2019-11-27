package com.petcare.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.petcare.web.domains.CustomerVO;

@Mapper
public interface CustomerMapper {
	
	void registCustomer(CustomerVO customerVO) throws Exception;

	CustomerVO getCustomerInfo(String user_id) throws Exception;
	
	int userIdCheck(CustomerVO customerVO) throws Exception;

}
