package com.aaronmorgan.languages.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aaronmorgan.languages.models.Language;
import com.aaronmorgan.languages.services.LanguageService;

@Controller
public class HomeController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allLanguages", this.lService.getAllLanguages());
		return "index.jsp";
	}
	
	@GetMapping("/{id}")
	public String viewLanguage(@ModelAttribute("language") Language language, Model model, @PathVariable("id") Long id) {
		Language oneLanguage = this.lService.findLanguage(id);
		model.addAttribute("language", oneLanguage);
		return "language.jsp";
	}
	
	@GetMapping("/new")
	public String add(@ModelAttribute("language") Language language) {
		return "new.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("hello");
			return "new.jsp";
		}
		System.out.println("goodbye");
		this.lService.createLanguage(language);
		return "redirect:/";
	}
	
	@PostMapping("/create")
	public String addLanguage(@RequestParam("name") String name, @RequestParam("creator") String creator, @RequestParam("version") Float version, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.length() < 2 ) {
			errors.add("please provide a longer name");
		}
		if(name.length() > 20 ) {
			errors.add("please provide a shorter name");
		}
		if(creator.length() < 2 ) {
			errors.add("please provide a longer creator name");
		}
		if(creator.length() > 20 ) {
			errors.add("please provide a shorter creator name");
		}
//		if(version.isNaN(): False) {
//			errors.add("please include version number");
//		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/new";
		
		}
		this.lService.createLanguageManually(name, creator, version);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model, @ModelAttribute("lanuage") Language language) {
		model.addAttribute("language", lService.findLanguage(id));
		return "edit.jsp";
	}
	@PostMapping("update/{id}")
	public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id, Model model) {
		Language oneLanguage = this.lService.findLanguage(id);
		model.addAttribute("language", oneLanguage);
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		this.lService.updateLanguage(language);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/";
		}
}
