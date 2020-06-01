package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.dto.NoticeSearchDto;
import com.ssafy.happyhouse.model.service.NoticeService;

@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/noticelist")
	public void noticelist(Model model, NoticeSearchDto noticeSearchDto) throws Exception {
		model.addAttribute("notices", noticeService.listArticle(noticeSearchDto.getKey(), noticeSearchDto.getWord()));
	}
	
	@GetMapping("/noticedetail")
	public void noticedetail(Model model, int noticeno) throws Exception {
		model.addAttribute("notice", noticeService.selectNoticeByNoticeNo(noticeno));
	}
	
	@GetMapping("/noticedelete")
	public String noticedelete(int noticeno) throws Exception {
		noticeService.deleteenotice(noticeno);
		return "redirect:/notice/noticelist";
	}
	
	private String noticedelete(HttpServletRequest request, HttpServletResponse response)throws Exception {
		int noticeno=Integer.parseInt(request.getParameter("noticeno"));
		noticeService.deleteenotice(noticeno);
		System.out.println(noticeno);
		return "redirect:/notice.do?act=noticelist&key=&word=";
	}
	
	private String noticedetail(HttpServletRequest request, HttpServletResponse response)throws Exception {
		int noticeno=Integer.parseInt(request.getParameter("noticeno"));
		System.out.println(noticeno);
		NoticeDto noticeDto=noticeService.selectNoticeByNoticeNo(noticeno);
		//request.setAttribute("notice", noticeDto);
		HttpSession session = request.getSession();
		session.setAttribute("notice", noticeDto);
		return "/notice/noticedetail.jsp";
	}
	
	private String noticelist(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		List<NoticeDto> list = noticeService.listArticle(key, word);
		request.setAttribute("notices", list);	
		return "/notice/noticelist.jsp";
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		String act = request.getParameter("act");
		try {
			switch (act == null ? "" : act) {
			case "noticelist":
				path = noticelist(request, response);
				break;
			case "writeForm":
				path = writeForm(request, response);
				break;
			case "write":
				path = noticewrite(request, response);
				break;
			case "detail":
				path = noticedetail(request, response);
				break;
			case "updateForm":
				path = updateForm(request, response);
				break;
			case "update":
				path = update(request, response);
				break;
			case "noticedelete":
				path = noticedelete(request, response);
				break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	private String update(HttpServletRequest request, HttpServletResponse response)throws Exception  {
		HttpSession session =request.getSession();	
		NoticeDto n =((NoticeDto)session.getAttribute("notice"));
		String subject=request.getParameter("subject");

			n.setSubject(subject.equals("")?n.getSubject():subject);
			n.setContent(request.getParameter("content"));
			noticeService.updatenotice(n);
		
		return "redirect:/notice.do?act=noticelist&key=&word=";
		
		
	}

	private String updateForm(HttpServletRequest request, HttpServletResponse response)throws Exception {
		return "/notice/noticeupdate.jsp";
	}



	private String noticewrite(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		HttpSession session =request.getSession();
		MemberDto memberDto=(MemberDto)session.getAttribute("loginUser");
		if(memberDto !=null) {
			NoticeDto n =new NoticeDto();
			n.setId(memberDto.getId());
			n.setName(memberDto.getName());
			n.setSubject(request.getParameter("subject"));
			n.setContent(request.getParameter("content"));
			noticeService.insertNotice(n);
		}
		return "redirect:/notice.do?act=noticelist&key=&word=";
	}

	private String writeForm(HttpServletRequest request, HttpServletResponse response)throws Exception {
		return "/notice/noticewrite.jsp";
	}

	

}
