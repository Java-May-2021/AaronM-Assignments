package com.aaronmorgan.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeControllers {
	@RequestMapping("/")
	public String index(@ModelAttribute("error") String error, Model model) {
		model.addAttribute("error",error);
		return "index.jsp";
	}
	
	@PostMapping(path="/code")
	public String theCode(@RequestParam(value="guess") String guess,RedirectAttributes redirectAttributes) {
		if(guess.equals("bushido")) {
			return "theCode.jsp";
		}
		else {
			redirectAttributes.addFlashAttribute("error","You must train harder!");
			return "redirect:/";
		}
	}
}
