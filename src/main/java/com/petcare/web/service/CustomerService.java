package com.petcare.web.service;

import com.petcare.web.domains.CustomerVO;

public interface CustomerService {
	
	// 신규고객을 등록한다.
	public void registCustomer(CustomerVO customerVO) throws Exception;
	
	// 유저 아이디로 고객을 조회한다.
	public CustomerVO getCustomerInfo(String user_id) throws Exception;

	
	public String userIdCheck(CustomerVO customerVO) throws Exception;
}
