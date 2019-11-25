package com.petcare.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.petcare.web.domains.HospitalVo;
import com.petcare.web.utills.Proxy;

@Repository
public interface HospitalSearchMapper {
	
	public ArrayList<HospitalVo> selectHospitalList(List<String> list);
	public ArrayList<HospitalVo> selectHospitalAllList(Proxy pxy);
	public ArrayList<HospitalVo> selectHospitalListByConodition(Proxy pxy);
	public HospitalVo selectHospitalDetail(String hosNo);
	public int countHospital(List<String> list); 
	public int countAllHospital(); 
	public int countHospitalByCondition(Proxy pxy); 
	
	public void insetHospitalDumpData(HospitalVo hosDatailDB);
}
