package com.ssafy.happyhouse.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.NewsDAO;
import com.ssafy.happyhouse.model.dto.NewsDto;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO dao;
	
	@Override
	public List<NewsDto> retrieveNews() throws IOException {
		return dao.selectNews();
	}

}
