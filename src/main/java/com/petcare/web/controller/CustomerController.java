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
import com.petcare.web.domains.LoginDTO;
import com.petcare.web.service.CustomerService;
import com.petcare.web.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserService userService;
	
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
	public String regist(@Valid CustomerVO customerVO, HttpServletRequest request,LoginDTO dto)
		throws Exception
	{
		customerService.registCustomer(customerVO);
		request.getSession().setAttribute("login", userService.login(dto));
		
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
	public String view(Model model,HttpServletRequest request) 
		throws Exception
	{
		
		
		CustomerVO customerVO = customerService.getCustomerInfo(((CustomerVO)request.getSession().getAttribute("login")).getUserId());
		
		model.addAttribute("customerVO", customerVO);
		
		return "customer/customerView";
	}

}
