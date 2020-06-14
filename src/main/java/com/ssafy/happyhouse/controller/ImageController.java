package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.happyhouse.model.dto.NewsDto;
import com.ssafy.happyhouse.model.service.ImageService;
import com.ssafy.happyhouse.model.service.NewsService;

@Controller
@RequestMapping(value = "/image")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public String linkImage(Model model,String name) throws IOException {
		System.out.println("이미지"); 
		if(name.indexOf("(") != -1) {
			name =name.substring(0, name.indexOf("("));
		}
		System.out.println(name);
		String link = imageService.retrieveImage(name);
		System.out.println(link);
		return "house/housedetail";	
	}
	
	@RequestMapping(value = "/image", method = RequestMethod.POST)
	public String linkImageInsert(Model model,String name) throws IOException {
		System.out.println("삽입중...");
		if(name.indexOf("(") != -1) {
			name =name.substring(0, name.indexOf("("));
		}
		System.out.println(name);
		String link = imageService.retrieveImage(name);
		model.addAttribute("linkedImage",link);
		System.out.println(link);
		return "house/housedetail";	
	}
}
