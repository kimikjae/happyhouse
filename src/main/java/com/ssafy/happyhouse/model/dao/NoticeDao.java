package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.dto.NoticeSearchDto;

public interface NoticeDao {

	public List<NoticeDto> listArticle(String key, String word) throws SQLException;
	public int insertNotice(NoticeDto noticeDto);
	public NoticeDto selectNoticeByNoticeNo(int noticeno);
	public int updateNotice(NoticeDto noticeDto);
	public int deleteNotice(int noticeno);
	public List<NoticeDto> selectAll()throws SQLException;
}
