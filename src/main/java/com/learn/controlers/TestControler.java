package com.learn.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestControler {
	
	
	
	@GetMapping("/signin")
	public String sigin() {
		
		
		return "signin";
	}

}
