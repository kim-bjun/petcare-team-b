package com.petcare.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.CustomerVO;
import com.petcare.web.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;

	@Override
	public void registCustomer(CustomerVO customerVO) throws Exception {
		customerMapper.registCustomer(customerVO);
	}

	@Override
	public CustomerVO getCustomerInfo(String user_id) throws Exception {
		return customerMapper.getCustomerInfo(user_id);
	}

	@Override
	public String userIdCheck(CustomerVO customerVO) throws Exception {

		int num = customerMapper.userIdCheck(customerVO);
		
		if ( num == 0) {
			return "true";
		}
		
		return "false";
	}
}
