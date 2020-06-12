package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.NoticeDao;
import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.dto.NoticeSearchDto;
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private  NoticeDao noticeDao;

	@Override
	public List<NoticeDto> listArticle(String key, String word) throws Exception {
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		return noticeDao.listArticle(key,word);
	}
	@Override
	public void insertNotice(NoticeDto noticedto) {
		noticeDao.insertNotice(noticedto);
	}

	@Override
	public NoticeDto selectNoticeByNoticeNo(int noticeno) {
		return noticeDao.selectNoticeByNoticeNo(noticeno);
	}
	@Override
	public void updatenotice(NoticeDto n) {
		noticeDao.updateNotice(n);
		
	}
	@Override
	public void deleteenotice(int noticeno) {
		noticeDao.deleteNotice(noticeno);
	}


}
