package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.DongDto;
import com.ssafy.happyhouse.model.dto.InteractionDto;
import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.dto.gugunDto;
import com.ssafy.happyhouse.model.service.CityService;
import com.ssafy.happyhouse.model.service.InterestLocationService;
import com.ssafy.happyhouse.model.service.SurroundService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/surround")
public class surroundRestController {
	@Autowired
	InterestLocationService interservice;
	
	@Autowired
	SurroundService surservice;
	@Autowired
	private CityService cityService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "관심정보의리스트를 가져온다", response = List.class)
	@GetMapping("/list2")
	public ResponseEntity<List<InteractionDto>> surround(HttpSession httpSession) throws IOException {
		MemberDto mem = (MemberDto) httpSession.getAttribute("loginUser");
		List<InteractionDto>list = interservice.selectlist(mem.getId());
		System.out.println(list.size());
		return new ResponseEntity<List<InteractionDto>>(list, HttpStatus.OK);
	}
//	@GetMapping("/delete")
//	public String delete(int no, Model model) throws IOException {
//		System.out.println("cont");
//		surservice.delete(no);
//		return "redirect:/surround/list";
//	}
	@SuppressWarnings("unchecked")
	@GetMapping("/selectByNo")
	public ResponseEntity<DongDto> movemap(@RequestParam Map<String, Object>param) throws IOException {
		int number= Integer.parseInt((String)param.get("no"));
		DongDto juso = surservice.selectByNo(number);
		String city=juso.getCity();
		String gu = juso.getGugun();
		String dong = juso.getDong();
		DongDto data = cityService.selectLocation(city,gu,dong);
		System.out.println(data.getLat());
		return new ResponseEntity<DongDto>(data, HttpStatus.OK);
	}
	
	
	
}
