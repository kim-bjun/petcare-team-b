package com.petcare.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.petcare.web.domains.FAQVO;
import com.petcare.web.utills.Criteria;


@Mapper
public interface FAQMapper {

	public List<FAQVO> readAll() throws Exception;
	public void create(FAQVO vo) throws Exception;
	public void update(FAQVO vo) throws Exception;
	public void delete(Integer faqNo) throws Exception;
	public List<FAQVO> listcri(Criteria cri) throws Exception;
	public int count() throws Exception;
}
