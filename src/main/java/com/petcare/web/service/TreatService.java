package com.petcare.web.service;

import java.util.List;

import com.petcare.web.domains.TreatVo;

public interface TreatService {
	public List<TreatVo> getList();
	
	public TreatVo get(int treat_no);
	
	public void regist(TreatVo treatVo);
	
	public boolean modify(TreatVo treatVo);
		
	public List<String> getTime();
}
