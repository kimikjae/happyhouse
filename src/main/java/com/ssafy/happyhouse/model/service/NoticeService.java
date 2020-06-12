package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeService {
	
	public List<NoticeDto> listArticle(String key, String word) throws Exception;
	public void insertNotice(NoticeDto noticedto);
	public NoticeDto selectNoticeByNoticeNo(int noticeno);
	public void updatenotice(NoticeDto noticedto);
	public void deleteenotice(int noticeno);
//	public void deleteArticle(int articleno) throws Exception;
	

}
