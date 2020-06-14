package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.gugunDto;
import com.ssafy.happyhouse.model.service.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping
@Api(value="SSAFY")
public class MainController {
	
	@Autowired
	private CityService cityService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "구의 정보를 가져온다.", response = List.class)
	@GetMapping(value = "/ci/{city}")
	public ResponseEntity<List<gugunDto>> findGugun(@PathVariable String city) throws Exception {
		System.out.println("aaaaa");
		List<gugunDto> gu = cityService.selectGu(city);
		System.out.println(gu.size());
		return new ResponseEntity<List<gugunDto>>(gu, HttpStatus.OK);
	}
}
