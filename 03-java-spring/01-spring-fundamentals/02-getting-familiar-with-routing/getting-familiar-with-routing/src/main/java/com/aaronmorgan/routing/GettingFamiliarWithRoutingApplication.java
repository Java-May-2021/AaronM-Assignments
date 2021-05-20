package com.aaronmorgan.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RestController
public class GettingFamiliarWithRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GettingFamiliarWithRoutingApplication.class, args);
	}
	
	@RequestMapping("/python")
	public String python() {
		return "Python/Django was awesome!";
	}
	@RequestMapping("/java")
	public String java() {
		return "Java/Spring is better!";
	}
}
