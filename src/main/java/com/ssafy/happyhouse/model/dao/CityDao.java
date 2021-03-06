package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.DongDto;
import com.ssafy.happyhouse.model.dto.gugunDto;

public interface CityDao {
	List<gugunDto>selectGu(String city);
	List<DongDto>selectDong(String city,String gu);
	List<DongDto>selectList(String city,String gu,String dong);
	DongDto selectLocation(String city,String gu,String dong);
	List<DongDto>selectAll();
	DongDto selectDongCode(String city, String gu, String dong);
}
