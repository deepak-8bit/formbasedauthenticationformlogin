package com.springsecurity.basic_securityWith_inmemorydatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Thyleafcontroler {
	
	@GetMapping("/signin")
	public String signin() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
