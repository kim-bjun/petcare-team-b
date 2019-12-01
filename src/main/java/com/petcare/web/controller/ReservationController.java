package com.petcare.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.petcare.web.domains.ReservationVo;
import com.petcare.web.domains.UserVO;
import com.petcare.web.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService service;

	@GetMapping("/list")
	public String list(@RequestParam(value="userId")String userId,Model model,HttpSession session) {
		
		//
		
		/*
		 * UserVO obj = (UserVO)session.getAttribute("login"); userId = obj.getUserid();
		 */
		model.addAttribute("userId",userId);			
			
		model.addAttribute("list",service.getList(userId));
			return "reservation/list";
		  
	}
		 
		 
	
	@PostMapping("/regist")
	public String register(ReservationVo Rvo,RedirectAttributes rttr,HttpSession session) {
     	
		//model.addAttribute("selectList",service.);
		UserVO obj = (UserVO)session.getAttribute("login");
		String userId = obj.getUserid();
	
		if(userId == null) {
			rttr.addFlashAttribute("msg","false");
			
		}else {
			Date today= new Date();
			SimpleDateFormat today1 = new SimpleDateFormat("HHmmss");
			int num= (int)(Math.random() * 10 + 1);
			int num1= Integer.parseInt(num +today1.format(today));
			
			Rvo.setTreatNo(num1);;
			Rvo.setUserId(userId);;
			Rvo.setHosNo(1);
			//Rvo.setAni_no(1);
			
			service.regist(Rvo);
			
		}
		return "redirect:/reservation/list";
		
	}
	
	
	@GetMapping("/regist/{hosNo}")
	public String regist(@PathVariable String hosNo, Model model) {
		System.out.println(hosNo+"<<<<<hosNo");
		model.addAttribute("hosNo", hosNo);
		return "reservation/regist";
	}
	
	
	@PostMapping("/modify")
	public String modify(ReservationVo vo ,RedirectAttributes rttr) {
		

		if(service.modify(vo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/reservation/list";
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam(value="treatNo") int treatNo,Model model) {
		model.addAttribute("board", service.get(treatNo));
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("treatNo") int treatNo,RedirectAttributes rttr) {
		if(service.remove(treatNo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/reservation/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("treatNo") int treatNo,Model model) {
		
		model.addAttribute("vo",service.get(treatNo));
	}
}
