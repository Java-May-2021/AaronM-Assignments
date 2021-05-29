package com.aaronmorgan.show.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronmorgan.show.models.Show;
import com.aaronmorgan.show.repositories.ShowRepository;

@Service
public class ShowService {
	private final ShowRepository sRepo;
	
	public ShowService(ShowRepository repo) {
		this.sRepo = repo;
	}
	// Display All
	public List<Show> getAllShows(){
		return this.sRepo.findAll();
	}
	
	// Display One
	public Show getSingleShow(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	// Create
	public Show createShow(Show show) {
		return this.sRepo.save(show);
	}
	
	// Delete
	public void deleteShow(Long id) {
		this.sRepo.deleteById(id);
	}
	
	// Update
	public Show updateShow(Show show) {
		return this.sRepo.save(show);
	}
}
