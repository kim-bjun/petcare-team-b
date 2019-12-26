package com.petcare.web.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.FAQVO;
import com.petcare.web.mapper.FAQMapper;
import com.petcare.web.utills.Paging;
import com.petcare.web.utills.SearchCriteria;

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
	public List<FAQVO> listcri(SearchCriteria cri) throws Exception {
		
		return mapper.listcri(cri);
	}
	
	@Override
	public List<FAQVO> searchlist(SearchCriteria cri) throws Exception {
		
		return mapper.searchlist(cri);
	}
	
	@Override
	public Paging makePage(SearchCriteria cri) throws Exception{
		
		int pageNo=cri.getPageNo();
		int perPage=cri.getPerPage();
		
		int totalCount=mapper.count(cri);
		
		Paging paging=new Paging(pageNo, totalCount,perPage);
		paging.setSearchType(cri.getSearchType());
		paging.setSearchContent(cri.getSearchContent());
		
		return paging;
	}
	
}
