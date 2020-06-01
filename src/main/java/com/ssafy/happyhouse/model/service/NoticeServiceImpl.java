package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.NoticeDao;
import com.ssafy.happyhouse.model.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private  NoticeDao noticeDao;

	@Override
	public List<NoticeDto> listArticle(String key, String word) throws Exception {
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		return noticeDao.listArticle(key, word);
	}
	@Override
	public void insertNotice(NoticeDto n) throws Exception {
		noticeDao.insertNotice(n);
	}

	@Override
	public NoticeDto selectNoticeByNoticeNo(int noticeno) throws Exception {
		return noticeDao.selectNoticeByNoticeNo(noticeno);
	}

	@Override
	public void updatenotice(NoticeDto n) throws Exception {
		noticeDao.updateNotice(n);
		
	}

	@Override
	public void deleteenotice(int noticeno) throws Exception {
		noticeDao.deleteNotice(noticeno);
	}




}
