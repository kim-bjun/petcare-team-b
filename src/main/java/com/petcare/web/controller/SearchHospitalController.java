package com.petcare.web.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.web.domains.HospitalVo;
import com.petcare.web.mapper.HospitalMapper;
import com.petcare.web.utills.Proxy;

@RestController
@RequestMapping("/sch")
public class SearchHospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired Map<String, Object>map;
	@Autowired HospitalVo hbean;
	@Autowired HospitalMapper hospitalMapper;
	@Autowired Proxy pxy;
	
	@GetMapping("/{pageNo}")  
	public Map<?,?> selectAllHospitalList(@PathVariable String pageNo , @RequestBody HospitalVo param ){
		pxy.setPageNum(pxy.parseInt(pageNo)); 
		Supplier<Integer> s = ()->hospitalMapper.countHospital();
		pxy.paging(s.get());	
		
		Supplier<List<HospitalVo>> n = () -> hospitalMapper.selectAllHospitalList(pxy);
		map.put("result", n.get());
		map.put("listInfo", pxy);
		map.put("result","SUCCESS");
		return map;
	}
	  
	@GetMapping("/detail/{hcode}")
	public Map<?,?> selectHospitalDetail(@PathVariable String hcode){
//		pxy.setSearchWrd(param);
//		Supplier<Integer> s = ()->hospitalMapper.countHospitalByCondition(pxy);
//		pxy.paging(s.get());	
//		
//		Supplier<List<HospitalBean>> n = () -> hospitalMapper.selectHospitalListByConodition(pxy);
//		map.put("result", n.get());
//		map.put("listInfo", pxy);
		map.put("result","SUCCESS");
		return map;
	}
	
	
}
