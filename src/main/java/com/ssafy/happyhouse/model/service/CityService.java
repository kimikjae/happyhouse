package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.DongDto;
import com.ssafy.happyhouse.model.dto.gugunDto;

public interface CityService {
	List<gugunDto>selectGu(String city);
	List<DongDto> selectDong(String city, String gu);
	List<DongDto> selectAll();
}
