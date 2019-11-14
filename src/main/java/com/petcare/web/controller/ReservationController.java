package com.petcare.web.controller;

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
		
		return "reservation/list";
	}
	
	@PostMapping("/regist")
	public String register(ReservationVo Rvo,RedirectAttributes rttr) {
		
		return "redirect:reservation/list";
	}
	@GetMapping("/regist")
	public void regist() {
		
	}
	
	
	@PostMapping("/modify")
	public String modify(ReservationVo vo ,RedirectAttributes rttr) {
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:reservation/list";
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam(value="res_no" ,required=false) int res_no,Model model) {
		model.addAttribute("board", service.get(res_no));
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("res_no") int res_no,RedirectAttributes rttr) {
		if(service.remove(res_no)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:reservation/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("res_no") int res_no,Model model) {
		
		model.addAttribute("vo",service.get(res_no));
	}
}
