package com.petcare.web.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.petcare.web.domains.AnimalVO;

public interface AnimalMapper {
	
	Integer getAnimailNumberRows(HashMap<String, Object> animalInfo) throws Exception;
	
	ArrayList<AnimalVO> getAnimalListRows(HashMap<String, Object> animalInfo) throws Exception;
	
	AnimalVO getAnimalInfo(HashMap<String, Object> animalInfo) throws Exception;

	void insertAnimal(AnimalVO animalVO) throws Exception;
	
	void updateAnimal(AnimalVO animalVO) throws Exception;
	
	void delteAnimal(AnimalVO animalVO) throws Exception;
}
