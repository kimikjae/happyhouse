package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.service.MapService;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/api/map")
public class MapController {
	
	@Autowired
	private MapService ms;
	    
	@GetMapping("/codetoaddress/{code}")
	public ResponseEntity<String> detailQnA(@PathVariable String code) {
		return new ResponseEntity<String>(ms.codeToCityGugun(code), HttpStatus.OK);
	}
}
