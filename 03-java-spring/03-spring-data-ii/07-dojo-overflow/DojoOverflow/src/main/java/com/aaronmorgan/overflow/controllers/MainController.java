package com.aaronmorgan.overflow.controllers;

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

import com.aaronmorgan.overflow.models.Answer;
import com.aaronmorgan.overflow.models.Question;
import com.aaronmorgan.overflow.models.Tag;
import com.aaronmorgan.overflow.services.MainService;




@Controller
public class MainController {
	@Autowired
	MainService qService;
	
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/questions";
	}
	@RequestMapping("/questions")
	public String index(Model viewModel) {
		viewModel.addAttribute("allQuestions", this.qService.getAllQuestions());
		return "index.jsp";
	}
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newQuestion") Question question, Model model) {
		return "newQuestion.jsp";
	}
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question Question, BindingResult result, Tag tag, Model model) {
				if(result.hasErrors())
					return "newQuestion.jsp";
				this.qService.createQuestion(Question);
				return "redirect:/questions";
			}
	@GetMapping("/questions/{id}")
	public String oneQuestion(@PathVariable("id") Long id, Model model,  @ModelAttribute("a") Answer answer) {
		model.addAttribute("question", this.qService.getSingleQuestion(id));		
		return "oneQuestion.jsp";
	}
	
	@PostMapping("/questions/answers")
	public String addAnswer(@Valid @ModelAttribute("a") Answer answer, BindingResult result, Model model, Long id) {
			if(result.hasErrors()) {
				return "oneQuestion.jsp";
			}
			this.qService.createAnswer(answer);
			return "redirect:/questions/";
	}
}
