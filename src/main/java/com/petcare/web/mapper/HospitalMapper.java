package com.petcare.web.mapper;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.petcare.web.domains.HospitalVo;
import com.petcare.web.utills.Proxy;

@Repository
public interface HospitalMapper {
	
	public ArrayList<HospitalVo> selectAllHospitalList(Proxy pxy);
	public ArrayList<HospitalVo> selectHospitalListByConodition(Proxy pxy);
	public HospitalVo selectHospitalDetail(String hcode);
	public int countHospital(); 
	public int countHospitalByCondition(Proxy pxy); 
	
}
