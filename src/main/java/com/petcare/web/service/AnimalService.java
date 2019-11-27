package com.petcare.web.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.petcare.web.domains.AnimalVO;

public interface AnimalService {
	
	Integer getAnimailNumberRows(HashMap<String, Object> animalInfo) throws Exception;
	
	ArrayList<AnimalVO> getAnimalListRows(HashMap<String, Object> animalInfo) throws Exception;
	
	AnimalVO getAnimalInfo(HashMap<String, Object> animalInfo) throws Exception;
	
	void insertAnimal(AnimalVO animalVO) throws Exception;
	
	void updateAnimal(AnimalVO animalVO) throws Exception;
	
	void delteAnimal(AnimalVO animalVO) throws Exception;
	

}
