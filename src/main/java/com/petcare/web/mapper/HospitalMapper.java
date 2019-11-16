package com.petcare.web.mapper;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.petcare.web.domains.HospitalBean;
import com.petcare.web.utills.Proxy;

@Repository
public interface HospitalMapper {
	
	public ArrayList<HospitalBean> selectAllHospitalList(Proxy pxy);
	public ArrayList<HospitalBean> selectHospitalListByConodition(Proxy pxy);
	public HospitalBean selectHospitalDetail(String hcode);
	public int countHospital(); 
	public int countHospitalByCondition(Proxy pxy); 
	
}
