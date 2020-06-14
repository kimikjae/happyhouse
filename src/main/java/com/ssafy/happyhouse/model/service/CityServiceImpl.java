package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.CityDao;
import com.ssafy.happyhouse.model.dto.gugunDto;
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao dao;
	@Override
	public List<gugunDto> selectGu(String city) {
		return dao.selectGu(city);
	}

}
