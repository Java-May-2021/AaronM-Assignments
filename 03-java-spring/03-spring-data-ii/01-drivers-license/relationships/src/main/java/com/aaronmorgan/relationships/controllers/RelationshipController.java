package com.aaronmorgan.relationships.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aaronmorgan.relationships.models.License;
import com.aaronmorgan.relationships.models.Person;
import com.aaronmorgan.relationships.services.RelationshipService;

@Controller
public class RelationshipController {
	@Autowired
	private RelationshipService rService;
	
	@GetMapping("/")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allPeople", this.rService.getAllPeople());
		return "index.jsp";
	}
	
	@GetMapping("/person/new")
	public String newPerson(@ModelAttribute("person")Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/person/create")
	public String addPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(firstName.length() < 2 ) {
			errors.add("please provide a longer first name");
		}
		if(firstName.length() > 20 ) {
			errors.add("please provide a shorter first name");
		}
		if(lastName.length() < 2 ) {
			errors.add("please provide a longer last name");
		}
		if(lastName.length() > 20 ) {
			errors.add("please provide a shorter last name");
		}
		if(errors.size() > 0) {
				redirectAttr.addFlashAttribute("errors", errors);
				return "redirect:/person/new";
			}
		this.rService.createPersonManually(firstName, lastName);
		return "redirect:/";
	}
	@GetMapping("/license/new")
	public String addLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> unlicensed = rService.UnlicensedPeople();
		model.addAttribute("people", unlicensed);
		return "newLicense.jsp";
	}
	
	
	@PostMapping("/license/create")
	public String createLicense(@Valid @ModelAttribute("license")License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		}
		else{
			rService.createLicense(license);
			return "redirect:/";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") Long id, Model model, @ModelAttribute("person") Person person) {
		model.addAttribute("person", rService.findPerson(id));
		return "edit.jsp";
	}
	@PostMapping("update/{id}")
	public String updatePerson(@Valid @ModelAttribute("person") Person person, BindingResult result, @PathVariable("id") Long id, Model model) {
		Person onePerson = this.rService.findPerson(id);
		model.addAttribute("person", onePerson);
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		this.rService.updatePerson(person);
		return "redirect:/";
	}
}
