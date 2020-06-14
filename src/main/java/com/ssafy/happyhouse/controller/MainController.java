package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.DongDto;
import com.ssafy.happyhouse.model.dto.SearchCityGu;
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
		List<gugunDto> gu = cityService.selectGu(city);
		return new ResponseEntity<List<gugunDto>>(gu, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "동의 정보를 가져온다.", response = List.class)
	@GetMapping(value = "/gugun")
	public ResponseEntity<List<DongDto>> findDong(@RequestParam Map<String, Object>param) throws Exception {
		String city=(String) param.get("city");
		String gu = (String) param.get("gu");
		List<DongDto> dong=cityService.selectDong(city,gu);
		return new ResponseEntity<List<DongDto>>(dong, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "지도 매물을 표시한다.", response = List.class)
	@GetMapping(value = "/map")
	public ResponseEntity<List<DongDto>> findLocation() throws Exception {
		List<DongDto> list = cityService.selectAll();
		return new ResponseEntity<List<DongDto>>(list, HttpStatus.OK);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "지도를 이동시킨다.", response = List.class)
	@GetMapping(value = "/map2")
	public ResponseEntity<List<DongDto>> findlist(@RequestParam Map<String, Object>param) throws Exception {
		String city=(String) param.get("city");
		String gu = (String) param.get("gu");
		String dong = (String)param.get("dong");
		List<DongDto> list = cityService.selectLocation(city,gu,dong);
		System.out.println(list.size());
		return new ResponseEntity<List<DongDto>>(list, HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
