package com.petcare.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.petcare.web.domains.HosInfoCodeVo;
import com.petcare.web.domains.HospitalVo;
import com.petcare.web.utills.Proxy;

@Repository
public interface HospitalSearchMapper {
	
	public ArrayList<HospitalVo> selectHospitalList(Proxy pxy);
	public ArrayList<HospitalVo> selectHospitalAllList(Proxy pxy);
	public ArrayList<HospitalVo> selectHospitalListByConodition(Proxy pxy);
	public HospitalVo selectHospitalDetail(String hosNo);
	public int countHospitalByCondition(Proxy pxy); 
	public int countAllHospital(); 
	
	public ArrayList<HosInfoCodeVo> selectHosInfoCode();
	
	public void insetHospitalDumpData(HospitalVo hosDatailDB);
}
