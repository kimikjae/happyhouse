package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.InteractionDto;
import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.service.InterestLocationService;

@RequestMapping("/interaction")
@Controller
public class interactionController {

	@Autowired
	InterestLocationService interservice;
	
	@GetMapping("/interform")
	public void interform() {}
	
	@PostMapping("/register")
	public String register(HttpSession httpSession, InteractionDto interDto) {
		MemberDto mem = (MemberDto) httpSession.getAttribute("loginUser");
		interDto.setMemberid(mem.getId());
		interservice.registLocation(interDto);
		return "/index";
	}
}
