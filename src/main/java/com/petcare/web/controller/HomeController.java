package com.petcare.web.controller;


import java.util.ArrayList;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.petcare.web.domains.HospitalVo;
import com.petcare.web.mapper.HospitalSearchMapper;
import com.petcare.web.utills.HospitalCrawlingProxy;

@Controller
public class HomeController {
	@Autowired HospitalCrawlingProxy hospitalCrawlingProxy;
	@Autowired HospitalSearchMapper hospitalSearchMapper;
	
	@GetMapping("/")
	public String home() throws Exception {
		System.out.println("home 시작");
		ArrayList<HospitalVo> tempList = new ArrayList<HospitalVo>();
		//tempList = hospitalCrawlingProxy.animal();
		Consumer<HospitalVo> t = s -> hospitalSearchMapper.insetHospitalDumpData(s);
		try {
			for (HospitalVo tempHosDetailDb : tempList) {
				//t.accept(tempHosDetailDb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
}
