package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.SurroundDAO;
import com.ssafy.happyhouse.model.dto.CommercialData;
import com.ssafy.happyhouse.model.dto.DongDto;

@Service
public class SurroundServiceImpl implements SurroundService{

	@Autowired
	private SurroundDAO dao;
	@Override
	public void delete(int no) {
		dao.delete(no);
	}
	@Override
	public DongDto selectByNo(int no) {
		return dao.selectByNo(no);
	}
	@Override
	public List<CommercialData> selectCodeName2(String codename1) {
		return dao.selectCodeName2(codename1);
	}
	@Override
	public List<CommercialData> selectCodeName3(String codename2) {
		return dao.selectCodeName3(codename2);
	}
	@Override
	public List<CommercialData> selectletlot(String codename1, String codename2, String codename3) {
		return dao.selectletlot(codename1,codename2,codename3);
	}

}
