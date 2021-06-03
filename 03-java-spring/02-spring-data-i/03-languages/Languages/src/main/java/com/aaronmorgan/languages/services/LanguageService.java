package com.aaronmorgan.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronmorgan.languages.models.Language;
import com.aaronmorgan.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.lRepo = repo;
	}
	// Display All
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	
	// Display One
	public Language getSingleLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	public Language findLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	// Create
	public Language createLanguage(Language language) {
		return this.lRepo.save(language);
	}
	
	//Create manually
	public Language createLanguageManually(String name, String creator, Float version) {
		Language newLanguage = new Language(name, creator, version);
		return this.lRepo.save(newLanguage);
	}
	
	
	// Delete
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
	
	// Update
	public Language updateLanguage(Language language) {
		return this.lRepo.save(language);
	}	
}
