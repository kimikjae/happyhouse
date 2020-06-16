package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.CommercialData;
import com.ssafy.happyhouse.model.dto.DongDto;
import com.ssafy.happyhouse.model.dto.gugunDto;

public interface SurroundDAO {
	public void delete(int no);
	DongDto selectByNo(int no);
	List<CommercialData>selectCodeName2(String codename1);
	List<CommercialData>selectCodeName3(String codename2);
	public List<CommercialData> selectletlot(String codename1, String codename2, String codename3);
}
