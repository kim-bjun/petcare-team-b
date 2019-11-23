package com.petcare.web.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.petcare.web.domains.LoginDTO;
import com.petcare.web.domains.UserVO;
import com.petcare.web.service.SampleService;
import com.petcare.web.service.UserService;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;
    @Autowired
	private UserService service;
    
    @GetMapping("/hi")
    @ResponseBody
    public String hi() {
        return "hi " +sampleService.getName() + " : " + sampleService.now();
    }

    @GetMapping("/home")
    public String sampleView() {
        return "home";
    }
    
    @GetMapping("/hospitaldetail")
    public String hospitalDetail() {
    	return "hospitalDetail";
    }
    
    @GetMapping("/hospitalsearch")
    public String hospitalSearch() {
    	return "hospitalSearch";
    }
    
       
    @GetMapping("/user/register")
    public String register() {
    	return "registerUser";
    }
    @RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String loginGET(@ModelAttribute("dto") LoginDTO dto) {
		return "login";
	}
	
	@RequestMapping(value="/user/loginPost",method=RequestMethod.POST)
	public String loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{
		UserVO vo=service.login(dto);
		if(vo==null) {
			return "home";
		}
		
		model.addAttribute("userVO",vo);
		if(dto.isUseCookie()) {
			int amount=60*60*24*7;
			Date sessionLimit=new Date(System.currentTimeMillis()+(1000*amount));
			service.keepLogin(vo.getUserid(),session.getId(),sessionLimit);
		}
		return "/user/loginPost";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
		Object obj=session.getAttribute("login");
		
		if(obj!=null) {
			UserVO vo=(UserVO) obj;
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie=WebUtils.getCookie(request, "loginCookie");
			if(loginCookie!=null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getUserid(),session.getId(), new Date());
			}
		}
		return "user/logout";
	}
	
	
		
	
}
