package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.DongCode;
import com.ssafy.happyhouse.model.dto.Green;
import com.ssafy.happyhouse.model.dto.InteractionDto;
import com.ssafy.happyhouse.model.dto.InterestLocation;

public interface GreenService {
	List<InterestLocation> selectInterestLocation(String memberid);
	List<Green> selectGreen(InterestLocation il);
	void deleteInterestLocation(InterestLocation il);
	void insertInterestLocation(InterestLocation il);
	int getNumByInterActionDTO(InteractionDto ia);
	List<DongCode> getDCByIL(InterestLocation il);
}
