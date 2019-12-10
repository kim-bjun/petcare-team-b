package com.petcare.web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.FAQVO;
import com.petcare.web.mapper.FAQMapper;
import com.petcare.web.utills.Criteria;

@Service
public class FAQServiceImpl implements FAQService {
	
	@Autowired
	FAQMapper mapper;

	@Override
	public List<FAQVO> readAll() throws Exception {
		
		return mapper.readAll();
	}
	
	@Override
	public void regist(FAQVO faqVO) throws Exception {
		mapper.create(faqVO);
	}

	@Override
	public void modify(FAQVO faqVO) throws Exception {
		mapper.update(faqVO);
	}

	@Override
	public void remove(Integer faqNo) throws Exception {
		mapper.delete(faqNo);
	}
	
	@Override
	public List<FAQVO> listcri(Criteria cri) throws Exception {
		
		return mapper.listcri(cri);
	}
}
