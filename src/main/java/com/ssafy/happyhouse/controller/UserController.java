package com.ssafy.happyhouse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.service.MemberService;

@RequestMapping("/user")
@Controller
public class UserController extends HttpServlet {
	
	@Autowired
	MemberService memberservice;
	
	@PostMapping("/loginform")
	public void loginForm() {}
	
	@PostMapping("/login")
	public String login(HttpSession httpSession, Model model, MemberDto memberDto) {
		MemberDto loginTried = memberservice.login(memberDto.getId(), memberDto.getPassword());
		if(loginTried != null) {
			httpSession.setAttribute("loginUser", loginTried);
		} else {
			model.addAttribute("errMsg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
		}
		return "/index";
	}
	
	@PostMapping("/registerform")
	public void registerForm() {}
	
	@PostMapping("/register")
	public String register(HttpSession httpSession, MemberDto memberDto) {
		memberservice.signup(memberDto);
		httpSession.setAttribute("loginUser", memberDto);
		return "/index";
	}
	
	@PostMapping("/list")
	public void list() {}
	
	@GetMapping("/modifyform")
	public void modifyform() {}
	
	@GetMapping("/delete")
	public String delete(HttpSession httpSession) {
		MemberDto member = (MemberDto) httpSession.getAttribute("loginUser");
		memberservice.delete(member);
		httpSession.invalidate();
		return "/user/deleteresult";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "/index";
	}
	
	@PostMapping("/modify")
	public String modify(HttpSession httpSession, MemberDto memberDto) {
		memberDto.setNo(((MemberDto)httpSession.getAttribute("loginUser")).getNo());
		memberservice.update(memberDto);
		httpSession.invalidate();
		return "/index";
	}
	
	
	private String modify(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto temp =(MemberDto)session.getAttribute("loginUser");
		int no = temp.getNo();
		String id= temp.getId();
		MemberDto memberdto= new MemberDto();
		memberdto.setNo(no);
		memberdto.setId(id);
		if(request.getParameter("password")==null||request.getParameter("password").equals("")) {
			memberdto.setPassword(temp.getPassword());
		}
		else {
			memberdto.setPassword(request.getParameter("password"));
		}
		if(request.getParameter("name")==null||request.getParameter("name").equals("")) {
			memberdto.setName(temp.getName());
		}
		else {
			memberdto.setName(request.getParameter("name"));
		}
		
		if(request.getParameter("address1")==null||request.getParameter("address1").equals("")) {
			memberdto.setAddress1(temp.getAddress1());
		}
		else {
			memberdto.setAddress1(request.getParameter("address1"));
		}
		if(request.getParameter("phonenumber")==null||request.getParameter("phonenumber").equals("")) {
			memberdto.setPhonenumber(temp.getPhonenumber());
		}
		else {
			memberdto.setPhonenumber(request.getParameter("phonenumber"));
		}
		memberservice.update(memberdto);
		session.setAttribute("loginUser", memberdto);
		return "/user/list.jsp";
	}
	
	/*
	private String mylist(HttpServletRequest request, HttpServletResponse response) {
		return "/user/list.jsp";
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		MemberDto memberdto = new MemberDto();
		memberdto.setId(request.getParameter("id"));
		memberdto.setPassword(request.getParameter("password"));
		memberdto.setName(request.getParameter("name"));
		memberdto.setAddress1(request.getParameter("address1"));
		memberdto.setPhonenumber(request.getParameter("phonenumber"));
		memberservice.signup(memberdto);
		return "/index.jsp";
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("일단들어옴");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDto memberDto = memberservice.login(id, password);
		if (memberDto != null) { // DB에 사용자 정보 존재
			System.out.println("들어옴");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", memberDto);
		} else { // DB에 사용자 정보 X
			request.setAttribute("errMsg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
		}
		return "/index.jsp";
	}

	/*
	private String loginform(HttpServletRequest request, HttpServletResponse response) {
		return "/user/loginForm.jsp";
	}

	private String registerForm(HttpServletRequest request, HttpServletResponse response) {
		return "/user/registerForm.jsp";
	}
	*/
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		String act = request.getParameter("act");
		try {
			switch (act == null ? "" : act) {
			case "registerForm":
				System.out.println("registerForm");
				//path = registerForm(request, response);
				break;
			case "register":
				System.out.println("register");
				//path = register(request, response);
				break;
			case "loginForm":
				System.out.println("loginForm");
				//path = loginform(request, response);
				break;
			case "login":
				System.out.println("login");
				//path = login(request, response);
				break;
			case "logout":
				System.out.println("logout");
				path=logout(request,response);
				break;
			case "mylist":
				System.out.println("mylist");
				//path=mylist(request,response);
				break;
			case "modifyForm":
				System.out.println("modifyForm");
				path=modifyForm(request,response);
				break;
			case "modify":
				System.out.println("modify");
				path=modify(request,response);
				break;
			case "delete":
				System.out.println("delete");
				path=delete(request,response);
				break;
			case "passwordSearchForm":
				System.out.println("passwordSearchForm");
				path=passwordSearchForm(request,response);
				break;
				
			case "passwordSearch":
				System.out.println("passwordSearch");
				path=passwordSearch(request,response);
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

	private String passwordSearch(HttpServletRequest request, HttpServletResponse response) {
		String id= request.getParameter("id");
		String pw = memberservice.search(id);
		request.setAttribute("pwd", pw);
		return "/user/passwordlist.jsp";
	}

	private String passwordSearchForm(HttpServletRequest request, HttpServletResponse response) {
		return "/user/passwordSearchForm.jsp";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberdto = (MemberDto) session.getAttribute("loginUser");
		memberservice.delete(memberdto);
		session.removeAttribute("loginUser");
		return "/user/deleteresult.jsp";
	}

	private String modifyForm(HttpServletRequest request, HttpServletResponse response) {
		return "/user/modifyForm.jsp";
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/user.do";
	}
}
