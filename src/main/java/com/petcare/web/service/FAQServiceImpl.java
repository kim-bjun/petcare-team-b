package com.petcare.web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.FAQVO;
import com.petcare.web.mapper.FAQMapper;

@Service
public class FAQServiceImpl implements FAQService {
	
	@Autowired
	FAQMapper mapper;

	@Override
	public List<FAQVO> readAll() throws Exception {
		
		return mapper.readAll();
	}

}
