package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.ImageService;

@Controller
@RequestMapping("/house")
public class HouseController {

	@Autowired
	private HouseService houseservice;
	@Autowired
	private ImageService imageservice;

	@GetMapping("/housedetail")
	public void deatil(Model model, int no) throws IOException {
		System.out.println("controller : detail()");
		model.addAttribute("home", houseservice.searchHouseByNo(no));
		String name = houseservice.searchHouseByNo(no).getAptName();
		if (name.indexOf("(") != -1) {
			name = name.substring(0, name.indexOf("("));
		}
		model.addAttribute("link", imageservice.retrieveImage(name));
	}

	@GetMapping("/qna")
	public String qna() {
		System.out.println("qna");
		return "/qna";
	}

	@GetMapping("/houselist")
	public void houselist(Model model, String pg, String searchWord) throws SQLException {
		System.out.println("controller : houselist()");
		System.out.println("pg는!!! : " + pg);
		int currentPage = Integer.parseInt(pg);
		int sizePerPage = 10; // 한 페이지에 보여줄 게시글 수 나중에 확인
		List<HouseDeal> list = null;
		if (searchWord == "" || searchWord == null) {
			list = houseservice.searchAll(currentPage, sizePerPage);
			model.addAttribute("navigation", houseservice.makePageNavigation(currentPage, sizePerPage,""));
		} else {
			list = houseservice.detaillist(currentPage, sizePerPage, searchWord);
			model.addAttribute("navigation", houseservice.makePageNavigation(currentPage, sizePerPage, searchWord));
		}
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("List", list);
		Gson gson = new Gson();
		model.addAttribute("jsonList", gson.toJson(list));
	}
}