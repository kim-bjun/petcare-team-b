package com.petcare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.ReservationVo;
import com.petcare.web.mapper.ReservationMapper;
@Service
public class ReservationServiceImpl implements ReservationService{

	
	@Autowired
	ReservationMapper mapper;

	@Override
	public ReservationVo get(int res_no) {
		return mapper.read(res_no);
	}

	@Override
	public void regist(ReservationVo reser) {
		mapper.insert(reser);
	}

	@Override
	public boolean modify(ReservationVo reser) {
		return mapper.update(reser)==1;
	}

	@Override
	public boolean remove(int res_no) {
		return mapper.delete(res_no)==1;
	}

	@Override
	public List<ReservationVo> getList() {
		return mapper.getList();
	}
}
