package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.gugunDto;

public interface CityDao {
	List<gugunDto>selectGu(String city);
}
