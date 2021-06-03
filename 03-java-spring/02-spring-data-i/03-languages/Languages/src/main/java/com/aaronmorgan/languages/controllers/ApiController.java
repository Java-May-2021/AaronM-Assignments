package com.aaronmorgan.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaronmorgan.languages.models.Language;
import com.aaronmorgan.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("")
	public List<Language> getLanguages(){
		return this.lService.getAllLanguages();
	}
	@GetMapping("/{id}")
	public Language getSingle(@PathVariable("id") Long id) {
		return this.lService.getSingleLanguage(id);	
	}
	
	@PostMapping("/create")
	public Language createLanguage(Language newLanguage) {
		return this.lService.createLanguage(newLanguage);
	}
	
	@PutMapping("/update/{id}")
	public Language edit(@PathVariable("id") Long id, Language updatedLanguage) {
		return this.lService.updateLanguage(updatedLanguage);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
	}
}

