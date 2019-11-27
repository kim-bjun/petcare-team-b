package com.petcare.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petcare.web.domains.CustomerVO;
import com.petcare.web.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@ModelAttribute("customerVO")
	protected Object registBack() throws Exception {
		return new CustomerVO();
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist(@ModelAttribute CustomerVO customerVO, Model model) {
		
		model.addAttribute("customerVO", customerVO);
		
		return "customer/customerRegist";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(@Valid CustomerVO customerVO, HttpServletRequest request)
		throws Exception
	{
		customerService.registCustomer(customerVO);
		
		return "redirect:/customer/view";
	}
	
	@RequestMapping(value= "/userIdCheck" , method = RequestMethod.POST)
	public String userIdCheck(CustomerVO customerVO, Model model)
		throws Exception 
	{
		String idCheckResult = customerService.userIdCheck(customerVO);
		
		model.addAttribute("idCheckResult", idCheckResult);
		
		return "customer/userIdCheck";
	}
	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model) 
		throws Exception
	{
		String imsi = "jongwook88";
		
		CustomerVO customerVO = customerService.getCustomerInfo(imsi);
		
		model.addAttribute("customerVO", customerVO);
		
		return "customer/customerView";
	}

}
