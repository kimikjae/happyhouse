package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.model.dto.SearchDto;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.HouseServiceImpl;
import com.ssafy.happyhouse.model.service.MemberService;
import com.ssafy.happyhouse.model.service.MemberServiceIpmI;
import com.ssafy.happyhouse.util.PageNavigation;

@WebServlet("/house.do")
public class HouseController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private HouseService houseservice;
	public HouseController() {
		houseservice = new HouseServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	private String detaillistByNo(HttpServletRequest request, HttpServletResponse response) {
		int no=Integer.parseInt(request.getParameter("no"));
		HouseDeal houseDeal=houseservice.searchHouseByNo(no);
		HttpSession session = request.getSession();
		session.setAttribute("home", houseDeal);	
		return "/house/housedetail.jsp";
	}

	private String detaillist(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		String type[]=new String[5];
		type[1]=request.getParameter("type1");
		type[2]=request.getParameter("type2");
		type[3]=request.getParameter("type3");
		type[4]=request.getParameter("type4");
		String option=request.getParameter("searchType");
		String searchWord=request.getParameter("searchWord");
		SearchDto searchDto = new SearchDto();
		searchDto.setType(type);
		searchDto.setOption(option);
		searchDto.setSearchWord(searchWord);
// 		-------- Dto 객체 세팅------------
		List<HouseDeal>houselist = houseservice.searchAll(searchDto);
		if(houselist.size()!=0) {
			request.setAttribute("List", houselist);
			if(option.equals("dong")) {
				request.setAttribute("AoptionD", option);
				request.setAttribute("dongimg", houselist.get(0).getDong());
			}else if(option.equals("AptName")) {
				request.setAttribute("Aptimg",houselist.get(0).getAptName());
				request.setAttribute("AoptionD", option);
			}
		}else if(houselist.size()==0) {
			request.setAttribute("List", "Empty");
		}
		return "/house/houselist.jsp";
	}

	private String houseAlllist(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		int currentPage = Integer.parseInt(request.getParameter("pg"));
		String spp = request.getParameter("spp");
		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);//sizePerPage
		List<HouseDeal> houselist = houseservice.searchAll(currentPage, sizePerPage);
		PageNavigation pageNavigation = houseservice.makePageNavigation(currentPage, sizePerPage);
		System.out.println(houselist.size());
		request.setAttribute("List", houselist);
		request.setAttribute("navigation", pageNavigation);
		return "/house/houselist.jsp";
	}

	
}
