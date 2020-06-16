package com.ssafy.happyhouse.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.SurroundDAO;

@Service
public class SurroundServiceImpl implements SurroundService{

	@Autowired
	private SurroundDAO dao;
	@Override
	public void delete(int no) {
		dao.delete(no);
	}

}
