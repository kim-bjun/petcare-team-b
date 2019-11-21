package com.petcare.web;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petcare.web.mapper.HospitalSearchMapper;
import com.petcare.web.utills.HospitalCrawlingProxy;

@Controller
public class HomeController {
	@Autowired HospitalSearchMapper hospitalSearchMapper;
	@Autowired HospitalCrawlingProxy hospitalCrawlingProxy;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		
		return "home";
	}
	
}
