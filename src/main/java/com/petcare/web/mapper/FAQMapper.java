package com.petcare.web.mapper;

import java.util.List;

import com.petcare.web.domains.FAQVO;

public interface FAQMapper {

	public List<FAQVO> readAll() throws Exception;
	
}
