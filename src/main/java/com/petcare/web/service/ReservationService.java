package com.petcare.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.web.domains.ReservationVo;


public interface ReservationService {
	
	public ReservationVo get(int res_no);
	
	public void regist(ReservationVo reser);
	
	public boolean modify(ReservationVo reser);
	
	public boolean remove(int res_no);
	
	public List<ReservationVo> getList();
	
}
