package com.learn.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeControler {
	
	
	@GetMapping("/home")
	public String home() {
		
		
		
		return "this is home page";
	}
	@GetMapping("/login")
	public String login() {
		
		
		
		return "this is login page";
	}


}
