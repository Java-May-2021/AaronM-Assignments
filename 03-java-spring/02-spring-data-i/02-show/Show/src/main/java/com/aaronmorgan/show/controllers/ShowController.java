package com.aaronmorgan.show.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaronmorgan.show.models.Show;
import com.aaronmorgan.show.services.ShowService;

@RestController
public class ShowController {
	@Autowired
	private ShowService sService;
	
	@GetMapping("/")
	public List<Show> getShows(){
		return this.sService.getAllShows();
	}
	
	@GetMapping("/{id}")
	public Show getSingle(@PathVariable("id") Long id) {
		return this.sService.getSingleShow(id);	
	}
	
	@PostMapping("/create")
	public Show createShow(Show newShow) {
		return this.sService.createShow(newShow);
	}
	
	@PostMapping("/update/{id}")
	public Show edit(@PathVariable("id") Long id, Show updatedShow) {
		return this.sService.updateShow(updatedShow);
	}
}
