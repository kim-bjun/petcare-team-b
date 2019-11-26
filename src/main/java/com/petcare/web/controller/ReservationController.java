package com.petcare.web.controller;

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
	public String register(ReservationVo Rvo,RedirectAttributes rttr) {
		
		//ReservationVo Rvo = new ReservationVo();
		//String userId= (String)session.getAttribute("userId");
		//Rvo.setUser_id(userId);
		Rvo.setTreat_no(8);
		Rvo.setUser_id("user1");
		Rvo.setHos_no(1);
		Rvo.setAni_no(1);
		Rvo.setReg_dt("20191120");
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
	public void modify(@RequestParam(value="treat_no" ,required=false) int treat_no,Model model) {
		model.addAttribute("board", service.get(treat_no));
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("treat_no") int treat_no,RedirectAttributes rttr) {
		if(service.remove(treat_no)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/reservation/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("treat_no") int treat_no,Model model) {
		
		model.addAttribute("vo",service.get(treat_no));
	}
}
