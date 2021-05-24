package com.aaronmorgan.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 0);
		}
		Integer newCount = (Integer) session.getAttribute("count");
		newCount++;
		session.setAttribute("count", newCount);
	return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		return "counter.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		Integer newCount = (Integer) session.getAttribute("count");
		newCount = 0;
		session.setAttribute("count", newCount);
		return "redirect:/";
	}
	@RequestMapping("/doublecount")
	public String doublecount(HttpSession session) {
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 0);
		}
		Integer newCount = (Integer) session.getAttribute("count");
		newCount +=2;
		session.setAttribute("count", newCount);
	return "index.jsp";
	}
}