package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.InteractionDto;
import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.service.InterestLocationService;

@RequestMapping("/surround")
@Controller
public class surroundController {
	@Autowired
	InterestLocationService interservice;
	
	@GetMapping("/list")
	public String surround(HttpSession httpSession, Model model) throws IOException {
		MemberDto mem = (MemberDto) httpSession.getAttribute("loginUser");
		List<InteractionDto>list = interservice.selectlist(mem.getId());
		System.out.println(list.size());
		model.addAttribute("interlist", list);
		return "surround/list";
	}
	@GetMapping("/delete")
	public String delete(HttpSession httpSession, Model model) throws IOException {
		MemberDto mem = (MemberDto) httpSession.getAttribute("loginUser");
		List<InteractionDto>list = interservice.selectlist(mem.getId());
		System.out.println(list.size());
		model.addAttribute("interlist", list);
		return "surround/list";
	}
}
