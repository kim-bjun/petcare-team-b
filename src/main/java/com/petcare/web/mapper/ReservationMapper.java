package com.petcare.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.petcare.web.domains.ReservationVo;

@Mapper
public interface ReservationMapper {
	
	public ReservationVo read(int treatNo);
	
	public void insert(ReservationVo reser);
	
	public int update(ReservationVo reser);
	
	public int delete(int treatNo);
	
	public List<ReservationVo> getList();

}

