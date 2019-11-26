package com.petcare.web.service;

import java.util.List;

import com.petcare.web.domains.FAQVO;

public interface FAQService {
	public List<FAQVO> readAll() throws Exception;
}
