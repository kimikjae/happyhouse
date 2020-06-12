package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.happyhouse.model.dto.NewsDto;
import com.ssafy.happyhouse.model.service.NewsService;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = "/newslist", method = RequestMethod.GET)
	public String list(Model model) throws IOException {
		List<NewsDto> list = newsService.retrieveNews();
		model.addAttribute("list",list);
		return "news/newslist";	
	}
}
