package com.ssafy.happyhouse.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.InterestlocationDao;
import com.ssafy.happyhouse.model.dto.InteractionDto;

@Service
public class InterestLocationServiceImpl implements InterestLocationService {

	@Autowired
	InterestlocationDao dao;
	
	@Override
	public void registLocation(InteractionDto interDto) {
		dao.insertLocation(interDto);
	}

	@Override
	public List<InteractionDto> selectlist(String id) throws IOException {
		return dao.selectInterestionById(id);
	}

}

