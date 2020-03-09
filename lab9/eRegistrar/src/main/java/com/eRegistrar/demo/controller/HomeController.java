package com.eRegistrar.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = {"/", "/eRegistrar", "/eRegistrar/home"})
	public String displayHomepage() {
		return "home/index";
	}
}
