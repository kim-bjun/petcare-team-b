package com.petcare.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.web.domains.ReservationVo;


public interface ReservationService {
	
	public ReservationVo get(int treatNo);
	
	public void regist(ReservationVo reser);
	
	public boolean modify(ReservationVo reser);
	
	public boolean remove(int treatNo);
	
	public List<ReservationVo> getList();

	public List<ReservationVo> getList(String userId);
	
}
