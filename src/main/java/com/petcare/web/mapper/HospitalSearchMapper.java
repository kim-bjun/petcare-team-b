package com.petcare.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.petcare.web.domains.HosInfoCodeVo;
import com.petcare.web.domains.HospitalVo;
import com.petcare.web.domains.JusoVo;
import com.petcare.web.utills.Proxy;

@Repository
public interface HospitalSearchMapper {
 
	//검색조건
	public ArrayList<JusoVo> selectCityCode(); 
	public ArrayList<JusoVo> selectGuCode(String city); 
	public ArrayList<HosInfoCodeVo> selectHosInfoCode();
	//페이지네이션을 위한 카운트
	public int countHospitalByCondition(Proxy pxy); 
	public int countAllHospital(Proxy pxy);
	//검색
	public ArrayList<HospitalVo> selectHospitalList(Proxy pxy);
	public ArrayList<HospitalVo> selectHospitalAllList(Proxy pxy);
	public ArrayList<HospitalVo> selectHospitalListByConodition(Proxy pxy);
	public HospitalVo selectHospitalDetail(String hosNo);

	//더미데이터 크롤링 insert
	public void insetHospitalDumpData(HospitalVo hosDatailDB);
}
