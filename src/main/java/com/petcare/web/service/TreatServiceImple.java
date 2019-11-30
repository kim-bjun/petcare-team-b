package com.petcare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.TreatVo;
import com.petcare.web.mapper.TreatMapper;
@Service
public class TreatServiceImple implements TreatService{
	@Autowired
	TreatMapper mapper;
	
	@Override
	public List<TreatVo> getList() {
		return mapper.getList();
	}

	@Override
	public TreatVo get(int treat_no) {
		return null;
	}

	@Override
	public void regist(TreatVo treatVo) {
		
	}

	@Override
	public boolean modify(TreatVo treatVo) {
		return false;
	}

	@Override
	public List<String> getTime() {
		return mapper.getTime();
	}

}
