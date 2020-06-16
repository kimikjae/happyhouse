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

import com.ssafy.happyhouse.model.dto.CommercialData;
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
	private InterestLocationService interservice;
	
	@Autowired
	private SurroundService surservice;
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
	
	@GetMapping("/deleteByNo")
	public ResponseEntity<List<InteractionDto>> delete(HttpSession httpSession, @RequestParam Map<String, Object>param) throws IOException {
		int no = Integer.parseInt((String)param.get("no"));
		surservice.delete(no);
		MemberDto mem = (MemberDto) httpSession.getAttribute("loginUser");
		List<InteractionDto>list = interservice.selectlist(mem.getId());
		return new ResponseEntity<List<InteractionDto>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/selectByNo")
	public ResponseEntity<DongDto> movemap(@RequestParam Map<String, Object>param) throws IOException {
		int number= Integer.parseInt((String)param.get("no"));
		DongDto juso = surservice.selectByNo(number);
		String city=juso.getCity();
		String gu = juso.getGugun();
		String dong = juso.getDong();
		DongDto data = cityService.selectLocation(city,gu,dong);
		return new ResponseEntity<DongDto>(data, HttpStatus.OK);
	}
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "중분류의 정보를 가져온다.", response = List.class)
	@GetMapping(value = "/codename2/{codename1}")
	public ResponseEntity<List<CommercialData>> findCodename2(@PathVariable String codename1) throws Exception {
		List<CommercialData> codename2 = surservice.selectCodeName2(codename1);
		return new ResponseEntity<List<CommercialData>>(codename2, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "중분류의 정보를 가져온다.", response = List.class)
	@GetMapping(value = "/codename3/{codename2}")
	public ResponseEntity<List<CommercialData>> findCodename3(@PathVariable String codename2) throws Exception {
		List<CommercialData> codename3 = surservice.selectCodeName3(codename2);
		return new ResponseEntity<List<CommercialData>>(codename3, HttpStatus.OK);
	}
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "좌표들고오기", response = List.class)
	@GetMapping(value = "/drawmap")
	public ResponseEntity<List<CommercialData>> findletlot(@RequestParam Map<String, Object>param) throws Exception {
		String codename1=(String) param.get("codename1");
		String codename2 = (String) param.get("codename2");
		String codename3 = (String)param.get("codename3");
		List<CommercialData> data = surservice.selectletlot(codename1,codename2,codename3);
		System.out.println(data.size());
		return new ResponseEntity<List<CommercialData>>(data, HttpStatus.OK);
	}
	
	
	
}
