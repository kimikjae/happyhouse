package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@PostMapping("/")
	public String homePost() {
		return "/index";
	}
}