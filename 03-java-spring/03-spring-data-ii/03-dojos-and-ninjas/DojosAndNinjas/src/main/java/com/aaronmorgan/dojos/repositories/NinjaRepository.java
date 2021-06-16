package com.aaronmorgan.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaronmorgan.dojos.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja>findAll();
}
