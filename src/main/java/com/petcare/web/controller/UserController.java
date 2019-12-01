package com.petcare.web.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.petcare.web.domains.CustomerVO;
import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;
import com.petcare.web.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET(@ModelAttribute("dto") LoginDTO dto) {
		return "login";
	}
	
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{
		CustomerVO vo=service.login(dto);
		if(vo==null) {
			return;
		}
		
		model.addAttribute("customerVO",vo);
		if(dto.isUseCookie()) {
			int amount=60*60*24*7;
			Date sessionLimit=new Date(System.currentTimeMillis()+(1000*amount));
			service.keepLogin(vo.getUser_id(),session.getId(),sessionLimit);
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public void logout(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
		Object obj=session.getAttribute("login");
		
		if(obj!=null) {
			CustomerVO vo=(CustomerVO) obj;
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie=WebUtils.getCookie(request, "loginCookie");
			if(loginCookie!=null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getUser_id(),session.getId(), new Date());
			}
		}
//		return "home";
	}
	
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage() {
		return "mypage";
	}
	
}
