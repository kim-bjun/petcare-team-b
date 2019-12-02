package com.petcare.web.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petcare.web.domains.AnimalVO;
import com.petcare.web.service.AnimalService;
import com.petcare.web.utills.PaginationUtil;
import com.petcare.web.utills.RequestMethodUtil;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@RequestMapping(value = "/aniList", method = RequestMethod.GET)
	public String list(Integer page, String condition, String words, Model model) 
		throws Exception
	{
		
		HashMap<String, Object> animalInfo = RequestMethodUtil.bbsNoneMethod(page, condition, words);
		
		String imsi = "jongwook88";
		
		animalInfo.put("user_id", imsi);
		
		//현재등록된 반려동물의 수 조회
		Integer numberRows = animalService.getAnimailNumberRows(animalInfo);
		
		//페이징 START
		long totalRows = Long.parseLong(numberRows.toString());
		long perPage = 10L;
		long numberLinks = 10L;
		long currentPage = Long.parseLong(animalInfo.get("page").toString());
		
		String paginationUtil 
					= PaginationUtil.instance.autoPaging(totalRows, perPage, numberLinks, currentPage);
		
		int lastPage = PaginationUtil.instance.getLastPage();
		int offset = PaginationUtil.instance.getOffset();
		int startNumber = numberRows - offset;
		//페이징 END
		
		animalInfo.put("limit", offset + (int) perPage);
		animalInfo.put("offset", offset + 1);
		animalInfo.put("startNo", startNumber);
		animalInfo.put("lastPage", lastPage);
		
		//조회결과 List
		ArrayList<AnimalVO> result = animalService.getAnimalListRows(animalInfo);
		
		model.addAttribute("Result", result);
		model.addAttribute("AnimalInfo", animalInfo);
		model.addAttribute("NumberRows", numberRows);
		model.addAttribute("PaginationUtil", paginationUtil);
		
		return "animal/aniList";
	}
	
	@RequestMapping(value= "/write", method = RequestMethod.GET)
	public String write( Integer page, String condition, String words, Model model)
		throws Exception
	{
		
		HashMap<String, Object> animalInfo = RequestMethodUtil.bbsNoneMethod(page, condition, words);
		
		model.addAttribute("AnimalInfo", animalInfo);
		
		return "animal/aniRegist";
	}
	
	@RequestMapping(value= "/write", method = RequestMethod.POST)
	public String write(@Valid AnimalVO animalVO, HttpServletRequest request,
			BindingResult br, Model model)
		throws Exception
	{
		
		String imsi = "jongwook88";
		
		HashMap<String, Object> animalInfo = RequestMethodUtil.bbsNoneMethod(
													Integer.parseInt(request.getParameter("page"))
												, 	request.getParameter("condition")
												, 	request.getParameter("words")
											);
		
		if(br.hasErrors()) {
			model.addAttribute("AnimalInfo",animalInfo);
			
			return "animal/aniRegist";
		}
		
		animalVO.setUserId(imsi);
		
		animalService.insertAnimal(animalVO);
		
		return "redirect:aniList?" + animalInfo.get("queryString");
	}
	
	@RequestMapping(value= "/modify/{indx}", method = RequestMethod.GET)
	public String modify(@PathVariable String indx, Integer page, String condition, String words, Model model) 
		throws Exception
	{
		HashMap<String, Object> animalInfo = RequestMethodUtil.bbsNoneMethod(page, condition, words);
		
		String imsi = "jongwook88";
		
		animalInfo.put("user_id", imsi);
		animalInfo.put("ani_no", indx);
		
		AnimalVO animalVO = animalService.getAnimalInfo(animalInfo);
		
		model.addAttribute("AnimalVO", animalVO);
		model.addAttribute("AnimalInfo", animalInfo);
		
		return "animal/aniModify";
	}
	
	@RequestMapping(value = "/modify/{indx}", method = RequestMethod.POST)
	public String modify(@PathVariable String indx, @Valid AnimalVO animalVO, BindingResult br,
							HttpServletRequest request, Model model)
		throws Exception
	{
		HashMap<String, Object> animalInfo = RequestMethodUtil.bbsNoneMethod(
													Integer.parseInt(request.getParameter("page"))
												, 	request.getParameter("condition")
												, 	request.getParameter("words")
											);
		
		if(br.hasErrors()) {
			model.addAttribute("AnimalVO", animalVO);
			model.addAttribute("AnimalInfo", animalInfo);
			
			return "animal/aniModify";
		}
		
		animalService.updateAnimal(animalVO);
		
		return "redirect:/animal/aniList?" + animalInfo.get("queryString");
	}
	
	@RequestMapping(value = "/delete/{indx}", method = RequestMethod.GET)
	public String delete(@PathVariable String indx, Integer page, String condition, String words, 
							HttpServletRequest request, Model model)
		throws Exception
	{
		String imsi = "jongwook88";
		
		HashMap<String, Object> animalInfo = RequestMethodUtil.bbsNoneMethod(page, condition, words);
		
		AnimalVO animalVO = new AnimalVO();
		animalVO.setUserId(imsi);
		animalVO.setAniNo(indx);
		
		animalService.delteAnimal(animalVO);
		
		return "redirect:/animal/aniList?" + animalInfo.get("queryString");
	}
	
	
	
	
	
	
	
	
	
}
