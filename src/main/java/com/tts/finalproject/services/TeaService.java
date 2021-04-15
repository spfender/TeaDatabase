package com.tts.finalproject.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.finalproject.models.Tea;
import com.tts.finalproject.repository.TeaRepository;

@Service
public class TeaService {

	@Autowired
	private TeaRepository teaRepository;

	public List<Tea> findAll() {
		List<Tea> teas = teaRepository.findAll();
		return teas;
	}

	public void save(Tea tea) {
		teaRepository.save(tea);
	}

	public void deleteById(long id) {
		teaRepository.deleteById(id);
	}
	
	public List<Tea> findByName(String name){
		List<Tea> teas = teaRepository.findByName(name);
		return teas;
	}

}