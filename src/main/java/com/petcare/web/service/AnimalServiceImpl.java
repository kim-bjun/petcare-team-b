package com.petcare.web.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.domains.AnimalVO;
import com.petcare.web.mapper.AnimalMapper;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalMapper animalMapper;
	
	@Override
	public Integer getAnimailNumberRows(HashMap<String, Object> animalInfo) throws Exception {
		return animalMapper.getAnimailNumberRows(animalInfo);
	}

	@Override
	public ArrayList<AnimalVO> getAnimalListRows(HashMap<String, Object> animalInfo) throws Exception {
		return animalMapper.getAnimalListRows(animalInfo);
	}

	@Override
	public AnimalVO getAnimalInfo(HashMap<String, Object> animalInfo) throws Exception {
		return animalMapper.getAnimalInfo(animalInfo);
	}

	@Override
	public void insertAnimal(AnimalVO animalVO) throws Exception {
		animalMapper.insertAnimal(animalVO);
	}

	@Override
	public void updateAnimal(AnimalVO animalVO) throws Exception {
		animalMapper.updateAnimal(animalVO);
	}

	@Override
	public void delteAnimal(AnimalVO animalVO) throws Exception {
		animalMapper.delteAnimal(animalVO);
	}

}
