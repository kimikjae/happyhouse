package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.InterestLocation;
import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.service.GreenService;

@Controller
@RequestMapping("/green")
public class GreenController {
	
	@Autowired
	GreenService gs;
	
	@GetMapping("/index")
	public void index(HttpSession httpSession, Model model) {
		List<InterestLocation> list = gs.selectInterestLocation(
				((MemberDto)httpSession.getAttribute("loginUser"))
				.getId());
		model.addAttribute(
			"List", gs.getDCByIL(list.get(0))
		);
	}
	
	@GetMapping("/delete")
	public String delete(HttpSession httpSession, int num) {
		InterestLocation il = new InterestLocation();
		il.setNum(num);
		gs.deleteInterestLocation(il);
		return "redirect:/green/index";
	}
}