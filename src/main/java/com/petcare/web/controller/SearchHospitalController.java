package com.petcare.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petcare.web.domains.HospitalVo;
import com.petcare.web.domains.ReviewBrdVo;
import com.petcare.web.mapper.HospitalSearchMapper;
import com.petcare.web.mapper.ReviewBrdMapper;
import com.petcare.web.utills.HospitalCrawlingProxy;
import com.petcare.web.utills.Proxy;

@Controller
@RequestMapping("/sch/*")
public class SearchHospitalController {
	@Autowired HospitalSearchMapper hospitalSearchMapper;
	@Autowired ReviewBrdMapper reviewBrdMapper;
	@Autowired HospitalCrawlingProxy hospitalCrawlingProxy;
	@Autowired Proxy pxy;

	
	@PostMapping("/hospitalList/{pageNo}")  
	public @ResponseBody Map<?,?> selectAllHospitalList(@PathVariable String pageNo, Model model ){
		Map<String, Object> map = new HashMap<String, Object>();
		Supplier<Integer> n = () -> hospitalSearchMapper.countHospital();
		pxy.setPageNo(Integer.parseInt(pageNo));
		pxy.paging(n.get());
		
		Function<Object,List<HospitalVo>> c = t -> hospitalSearchMapper.selectHospitalList(pxy);
		map.put("result", c.apply(pxy));
		map.put("pagination", pxy);
		map.put("msg","SUCCESS");
		return map;
	}
	
	@GetMapping("/detail")  
	public String selectHospitalDetail(@RequestParam("hosNo") String hosNo, Model model){
		Function<String,HospitalVo> n = t -> hospitalSearchMapper.selectHospitalDetail(t);
		model.addAttribute("result",n.apply(hosNo));
		
		return "hospitalDetail";
		
	}
	
	@GetMapping("/{hosNo}/pageNo/{pageNo}")  
	public @ResponseBody Map<String,Object> selectAllReview(@PathVariable String hosNo, @PathVariable String pageNo){
		Map<String, Object> tempMap =new HashMap<String, Object>();
		Function<String,Integer> c = t -> reviewBrdMapper.cntReview(t);		
		pxy.setHosNo(Integer.parseInt(hosNo));
		pxy.setPageNo(Integer.parseInt(pageNo));
		pxy.paging(c.apply(hosNo));
		
		Function<Object,List<ReviewBrdVo>> r = t -> reviewBrdMapper.selectReview(pxy);
		tempMap.put("review", r.apply(pxy));
		tempMap.put("pagenation", pxy);
		
		return tempMap;
		
	}
	
	@GetMapping("/crawling")
	public @ResponseBody Map<String,String> crawlingAllHospitalDB(){
		Map<String, String> tempMap =new HashMap<String, String>();
		Consumer<HospitalVo> t = s -> hospitalSearchMapper.insetHospitalDumpData(s);
		
		try {
			for (HospitalVo tempHosDetailDb : hospitalCrawlingProxy.animal()) {
				t.accept(tempHosDetailDb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		tempMap.put("msg", "SUCCESS");
		
		return tempMap;
		
	}
	
	
}
