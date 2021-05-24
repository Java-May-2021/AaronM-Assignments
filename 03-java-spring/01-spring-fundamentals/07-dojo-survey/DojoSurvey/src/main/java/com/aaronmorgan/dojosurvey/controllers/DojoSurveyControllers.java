package com.aaronmorgan.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyControllers {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/sessioned")
	public String result(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment, Model model) {
		model.addAttribute("name", name);		
		model.addAttribute("location", location);		
		model.addAttribute("language", language);		
		model.addAttribute("comment", comment);
		if(language.equals("java")) {
			return "java.jsp";
		}
		else {
		return "sessioned.jsp";
		}
	}
}
