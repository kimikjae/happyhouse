package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeDao {

	public List<NoticeDto> listArticle(String key, String word) throws SQLException;
	public void insertNotice(NoticeDto noticeDto) throws SQLException;
	public NoticeDto selectNoticeByNoticeNo(int noticeno) throws SQLException;
	public void updateNotice(NoticeDto n)throws SQLException;
	public void deleteNotice(int noticeno)throws SQLException;
	
//	public void deleteArticle(int articleno) throws SQLException;
	
}
