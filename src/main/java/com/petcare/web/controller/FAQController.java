package com.petcare.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petcare.web.domains.FAQVO;
import com.petcare.web.service.FAQService;
import com.petcare.web.utills.Criteria;

@Controller
@RequestMapping("/faq")
public class FAQController {

	@Autowired
	FAQService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model,Criteria cri) throws Exception {
		List<FAQVO> volist=service.listcri(cri);
		System.out.println(volist);
		model.addAttribute("list",volist);
		
		return "/faq/faqlist";
	}
}
