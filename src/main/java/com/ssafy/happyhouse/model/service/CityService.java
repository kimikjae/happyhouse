package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.gugunDto;

public interface CityService {
	List<gugunDto>selectGu(String city);
}
