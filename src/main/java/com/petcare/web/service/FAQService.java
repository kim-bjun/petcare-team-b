package com.petcare.web.service;

import java.util.List;

import com.petcare.web.domains.FAQVO;
import com.petcare.web.utills.Criteria;
import com.petcare.web.utills.Paging;
import com.petcare.web.utills.SearchCriteria;

public interface FAQService {
	public List<FAQVO> readAll() throws Exception;
	public void regist(FAQVO faqVO) throws Exception;
	public void modify(FAQVO faqVO) throws Exception;
	public void remove(Integer faqNo) throws Exception;
	public List<FAQVO> listcri(SearchCriteria cri) throws Exception;
	public List<FAQVO> searchlist(SearchCriteria cri) throws Exception;
	public Paging makePage(SearchCriteria cri) throws Exception;
}
