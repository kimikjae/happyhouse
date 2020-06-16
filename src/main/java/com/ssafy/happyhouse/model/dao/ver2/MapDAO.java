package com.ssafy.happyhouse.model.dao.ver2;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Green;

public interface MapDAO {
	String selectAddress(String code);

	List<Green> selectGreenByDong(String dong);
}
