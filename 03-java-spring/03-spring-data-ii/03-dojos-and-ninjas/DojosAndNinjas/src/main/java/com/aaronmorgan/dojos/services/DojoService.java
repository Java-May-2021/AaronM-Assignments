package com.aaronmorgan.dojos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronmorgan.dojos.models.Dojo;
import com.aaronmorgan.dojos.models.Ninja;
import com.aaronmorgan.dojos.repositories.DojoRepository;
import com.aaronmorgan.dojos.repositories.NinjaRepository;

@Service
public class DojoService {
	private final NinjaRepository nRepo;
	private final DojoRepository dRepo;
	public DojoService(NinjaRepository nRepo, DojoRepository repo) {
		this.dRepo = repo;
		this.nRepo = nRepo;
	}

	
	//Display All
	public List<Dojo> getAllDojos(){
		return this.dRepo.findAll();
	}
	
	//Display One
	public Dojo getSingleDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	public Dojo findDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	//Create
	public Dojo createDojo(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
	
	//Update
	public Dojo updateSong(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
	
	//Delete
	public void deleteDojo(Long id) {
		this.dRepo.deleteById(id);
	}
	
	//Create Manually
	public Dojo createDojoManually(String name) {
		Dojo newDojo = new Dojo(name);
		return this.dRepo.save(newDojo);
	}

	
	//NINJAS
	
	//Display All
	public List<Ninja> getAllNinjas(){
		return this.nRepo.findAll();
	}
	
	//Display One
	public Ninja getSingleNinja(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	public Ninja findNinja(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	
	//Create
	public Ninja createNinja(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	
}
