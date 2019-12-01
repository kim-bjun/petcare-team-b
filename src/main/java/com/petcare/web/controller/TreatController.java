package com.petcare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petcare.web.service.TreatService;

@Controller
@RequestMapping("/treat")
public class TreatController {
	
	@Autowired
	TreatService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("treatList", service.getList());
		model.addAttribute("selectList",service.getTime());
		return "treat/list";
	}
}
