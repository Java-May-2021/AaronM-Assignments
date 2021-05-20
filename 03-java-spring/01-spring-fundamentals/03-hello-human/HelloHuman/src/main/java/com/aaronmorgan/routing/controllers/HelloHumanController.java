package com.aaronmorgan.routing.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class HelloHumanController {
    @RequestMapping("/")
    public String human() {
            return "Hello Human! Welcome to SpringBoot!";
    }
	@RequestMapping("/name={name}")
	public String humanName(@PathVariable("name") String name) {

		return String.format("Hello %s! Welcome to SpringBoot!", name);
	}
}










