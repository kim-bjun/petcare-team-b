package com.petcare.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String list(Model model) {
		
		model.addAttribute("list",service.getList());
		//model.addAttribute("selectList",service.);
		
		return "reservation/list";
	}
	
	@PostMapping("/regist")
	public String register(ReservationVo Rvo,RedirectAttributes rttr,HttpSession session) {
     	
		UserVO obj = (UserVO)session.getAttribute("login");
		String userId = obj.getUserid();
		
		Rvo.setTreatNo(32);;
		Rvo.setUserId(userId);;
		//Rvo.setUserId("user1");
		Rvo.setHosNo(1);
		//Rvo.setAni_no(1);
		
		service.regist(Rvo);
		
		return "redirect:/reservation/list";
	}
	@GetMapping("/regist")
	public void regist() {
		
	}
	
	
	@PostMapping("/modify")
	public String modify(ReservationVo vo ,RedirectAttributes rttr) {
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/reservation/list";
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam(value="treatNo" ,required=false) int treatNo,Model model) {
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
