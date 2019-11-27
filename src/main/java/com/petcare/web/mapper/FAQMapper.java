package com.petcare.web.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.petcare.web.domains.FAQVO;

@Mapper

import com.petcare.web.domains.FAQVO;


public interface FAQMapper {

	public List<FAQVO> readAll() throws Exception;
	
}
