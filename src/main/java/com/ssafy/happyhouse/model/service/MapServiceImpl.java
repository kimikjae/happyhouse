package com.ssafy.happyhouse.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.ver2.MapDAO;

@Service
public class MapServiceImpl implements MapService {
	
	@Autowired
	private MapDAO md;

	@Override
	public String codeToCityGugun(String code) {
		// TODO Auto-generated method stub
		return md.selectAddress(code);
	}
}
