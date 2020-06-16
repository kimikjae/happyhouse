package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.ver2.GreenDAO;
import com.ssafy.happyhouse.model.dto.DongCode;
import com.ssafy.happyhouse.model.dto.Green;
import com.ssafy.happyhouse.model.dto.InteractionDto;
import com.ssafy.happyhouse.model.dto.InterestLocation;

@Service
public class GreenServiceImpl implements GreenService {
	
	@Autowired
	GreenDAO gd;

	@Override
	public List<InterestLocation> selectInterestLocation(String memberid) {
		// TODO Auto-generated method stub
		return gd.selectInterestLocation(memberid);
	}

	@Override
	public List<Green> selectGreen(InterestLocation il) {
		// TODO Auto-generated method stub
		return gd.selectGreen(il);
	}

	@Override
	public void deleteInterestLocation(InterestLocation il) {
		// TODO Auto-generated method stub
		gd.deleteInterestLocation(il);
	}

	@Override
	public void insertInterestLocation(InterestLocation il) {
		// TODO Auto-generated method stub
		gd.insertInterestLocation(il);
	}

	@Override
	public int getNumByInterActionDTO(InteractionDto ia) {
		// TODO Auto-generated method stub
		return gd.getNumByInterActionDTO(ia);
	}

	@Override
	public List<DongCode> getDCByIL(InterestLocation il) {
		// TODO Auto-generated method stub
		return gd.getDCByIL(il);
	}

}
