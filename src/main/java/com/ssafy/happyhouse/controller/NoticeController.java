package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.dto.NoticeSearchDto;
import com.ssafy.happyhouse.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

//	@ApiOperation(value = "모든 사원의 정보를 반환한다.", response = List.class)
//    @GetMapping(value = "/noticelist/all")
//	public ResponseEntity<List<NoticeDto>> findAllEmployees() throws Exception {
//		List<NoticeDto> list = noticeService.selectAll();
//		System.out.println(list.size());
//		if (list.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<NoticeDto>>(list, HttpStatus.OK);
//	}
//	@GetMapping("/noticeSearch")
//	public void noticesearch(Model model, NoticeSearchDto noticeSearchDto) throws
	
	
	@GetMapping("/noticelist")
	public void noticelist(Model model, NoticeSearchDto noticeSearchDto) throws Exception {
		List<NoticeDto>list = noticeService.listArticle(noticeSearchDto.getKey(), noticeSearchDto.getWord());
		System.out.println(list.size());
		model.addAttribute("notices", list);
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
	
	@PostMapping("/noticewrite")
	public void noticewrite() {}
	
	@PostMapping("/write")
	public String write(HttpSession httpSession, NoticeDto noticeDto) throws Exception {
		MemberDto member = (MemberDto)httpSession.getAttribute("loginUser");
		noticeDto.setId(member.getId());
		noticeDto.setName(member.getName());
		noticeService.insertNotice(noticeDto);
		return "redirect:/notice/noticelist";
	}
	
	@GetMapping("/noticeupdate")
	public void noticeupdate(Model model, int noticeno) throws Exception {
		model.addAttribute("notice",noticeService.selectNoticeByNoticeNo(noticeno));
	}
	
	@PostMapping("/update")
	public String update(NoticeDto noticeDto) throws Exception {
		noticeService.updatenotice(noticeDto);
		return "redirect:/notice/noticedetail?noticeno=" + noticeDto.getNoticeno();
	}


	

}
