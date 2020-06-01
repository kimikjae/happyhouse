package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeService {
	
	public List<NoticeDto> listArticle(String key, String word) throws Exception;
	public void insertNotice(NoticeDto n)throws Exception;
	public NoticeDto selectNoticeByNoticeNo(int noticeno) throws Exception;
	public void updatenotice(NoticeDto n)throws Exception;
	public void deleteenotice(int noticeno)throws Exception;
	
//	public void deleteArticle(int articleno) throws Exception;
	

}
