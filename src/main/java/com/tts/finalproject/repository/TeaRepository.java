package com.tts.finalproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.finalproject.models.Tea;

@Repository
public interface TeaRepository extends CrudRepository<Tea, Long>
{
	@Override
	public List<Tea> findAll();
	public List<Tea> findByName(String name);
}
