package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.SearchDto;
import com.ssafy.happyhouse.model.service.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {

	@Autowired
	private HouseService houseservice;

	@GetMapping("/housedetail")
	public void deatil(Model model, int no) {
		System.out.println("controller : detail()");
		model.addAttribute("home", houseservice.searchHouseByNo(no));
	}
	@GetMapping("/qna")
	public String qna() {
		System.out.println("qna");
		return "/qna";
	}
	@PostMapping("/houselist")
	public void houselistPost(Model model, String pg) throws SQLException {
		int currentPage = Integer.parseInt(pg);
		int sizePerPage = 10; // 한 페이지에 보여줄 게시글 수 나중에 확인
		List<HouseDeal> list = houseservice.searchAll(currentPage, sizePerPage);
		model.addAttribute("List", list);
		model.addAttribute("navigation", houseservice.makePageNavigation(currentPage, sizePerPage));
	}

	@GetMapping("/houselist")
	public void houselist(Model model, String pg) throws SQLException {
		System.out.println("controller : houselist()");
		int currentPage = Integer.parseInt(pg);
		int sizePerPage = 10; // 한 페이지에 보여줄 게시글 수 나중에 확인
		List<HouseDeal> list = houseservice.searchAll(currentPage, sizePerPage);

		model.addAttribute("List", list);
		model.addAttribute("navigation", houseservice.makePageNavigation(currentPage, sizePerPage));
	}

	@PostMapping("/searchlist")
	public String searchlist(String searchWord, Model model) throws SQLException {
//		String type[] = new String[5];
//		type[1] = type1;
//		type[2] = type2;
//		type[3] = type3;
//		type[4] = type4;
//		String searType = searchType;
//		String searWord = searchWord;
//		SearchDto searchDto = new SearchDto();
		//searchDto.setType(type);
//		searchDto.setSearchType(searchType);
//		searchDto.setSearchWord(searWord);
// 		-------- Dto 객체 세팅------------
		List<HouseDeal> houselist = houseservice.detaillist(searchWord);
		model.addAttribute("List", houselist);
		if (houselist == null) {}
//		else if (searType.equals("dong")) {
//			model.addAttribute("AoptionD", searType);
//			model.addAttribute("dongimg", houselist.get(0).getDong());
//		} else if (searType.equals("AptName")) {
//			model.addAttribute("AoptionD", searType);
//			model.addAttribute("Aptimg", houselist.get(0).getAptName());
//		}
		return "/house/houselist";
	}
	

	/*
	private String detaillist(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		String type[] = new String[5];
		type[1] = request.getParameter("type1");
		type[2] = request.getParameter("type2");
		type[3] = request.getParameter("type3");
		type[4] = request.getParameter("type4");
		String option = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		SearchDto searchDto = new SearchDto();
		searchDto.setType(type);
		searchDto.setOption(option);
		searchDto.setSearchWord(searchWord);
// 		-------- Dto 객체 세팅------------
		List<HouseDeal> houselist = houseservice.searchAll(searchDto);
		if (houselist.size() != 0) {
			request.setAttribute("List", houselist);
			if (option.equals("dong")) {
				request.setAttribute("AoptionD", option);
				request.setAttribute("dongimg", houselist.get(0).getDong());
			} else if (option.equals("AptName")) {
				request.setAttribute("Aptimg", houselist.get(0).getAptName());
				request.setAttribute("AoptionD", option);
			}
		} else if (houselist.size() == 0) {
			request.setAttribute("List", "Empty");
		}
		return "/house/houselist.jsp";
	}

	private String detaillistByNo(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		HouseDeal houseDeal = houseservice.searchHouseByNo(no);
		HttpSession session = request.getSession();
		session.setAttribute("home", houseDeal);
		return "/house/housedetail.jsp";
	}

	private String houseAlllist(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		int currentPage = Integer.parseInt(request.getParameter("pg"));
		String spp = request.getParameter("spp");
		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);// sizePerPage
		List<HouseDeal> houselist = houseservice.searchAll(currentPage, sizePerPage);
		PageNavigation pageNavigation = houseservice.makePageNavigation(currentPage, sizePerPage);
		System.out.println(houselist.size());
		request.setAttribute("List", houselist);
		request.setAttribute("navigation", pageNavigation);
		return "/house/houselist.jsp";
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		String act = request.getParameter("act");
		try {
			switch (act == null ? "" : act) {
			case "houselist":
				System.out.println("houselist");
				path = houseAlllist(request, response);
				break;
			case "detaillist":
				System.out.println("detaillist");
				path = detaillist(request, response);
				break;

			case "detaillistByNo":
				System.out.println("detaillistByNo");
				path = detaillistByNo(request, response);
				break;
			}
		} catch (Exception e) {
			path = "/error.jsp";
			request.setAttribute("errMsg", "처리시 에러가 발생했습니다.");
		}
		if (path.startsWith("redirect:")) {
			response.sendRedirect(request.getContextPath() + path.substring("redirect:".length()));
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	 */
}