package com.ssafy.happyhouse.model.dao.ver2;

import java.util.List;

import com.ssafy.happyhouse.model.dto.DongCode;
import com.ssafy.happyhouse.model.dto.Green;
import com.ssafy.happyhouse.model.dto.InteractionDto;
import com.ssafy.happyhouse.model.dto.InterestLocation;

public interface GreenDAO {
	List<InterestLocation> selectInterestLocation(String memberid);
	List<Green> selectGreen(InterestLocation ic);
	void deleteInterestLocation(InterestLocation ic);
	void insertInterestLocation(InterestLocation ic);
	int getNumByInterActionDTO(InteractionDto ia);
	List<DongCode> getDCByIL(InterestLocation il);
}
