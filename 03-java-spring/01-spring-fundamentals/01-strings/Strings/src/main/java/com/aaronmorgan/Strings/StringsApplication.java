package com.aaronmorgan.Strings;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello Client! How are you doing?";
	}
	@RequestMapping("/random")
	public String random() {
		return "Spring Boot is Great! So easy to just respond with strings";
	}
}
