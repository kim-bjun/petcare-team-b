package com.petcare.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petcare.web.domains.FAQVO;
import com.petcare.web.service.FAQService;
import com.petcare.web.utills.Criteria;
import com.petcare.web.utills.Paging;

@Controller
@RequestMapping("/faq")
public class FAQController {

	@Autowired
	FAQService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model,Criteria cri) throws Exception {
		List<FAQVO> volist=service.listcri(cri);
		Paging pageList=service.makePage(cri);
		System.out.println(volist);
		model.addAttribute("list",volist);
		model.addAttribute(pageList);
		
		return "/faq/faqlist";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void registGET() throws Exception{
		
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String registPOST(RedirectAttributes rttr, FAQVO vo) throws Exception{
		service.regist(vo);
		rttr.addFlashAttribute("msg","SUCCESS" );
		return "redirect:/faq/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(RedirectAttributes rttr, int faqNo) throws Exception{
		service.remove(faqNo);
		rttr.addFlashAttribute("msg","SUCCESS" );
		return "redirect:/faq/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(Model model,FAQVO vo) throws Exception{
		System.out.println(vo);
		model.addAttribute("faq",vo);
		
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(RedirectAttributes rttr, FAQVO vo) throws Exception{
		System.out.println(vo);
		service.modify(vo);
		rttr.addFlashAttribute("msg","SUCCESS" );
		return "redirect:/faq/list";
	}
}
