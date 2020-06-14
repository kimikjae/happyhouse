package com.ssafy.happyhouse.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.ImageDAO;
import com.ssafy.happyhouse.model.dao.NewsDAO;
import com.ssafy.happyhouse.model.dto.NewsDto;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDAO dao;

	@Override
	public String retrieveImage(String name) throws IOException {
		return dao.selectImage(name);
	}
	

}
