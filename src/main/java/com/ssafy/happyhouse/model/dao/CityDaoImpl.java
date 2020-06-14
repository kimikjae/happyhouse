package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.DongDto;
import com.ssafy.happyhouse.model.dto.gugunDto;

@Repository
public class CityDaoImpl implements CityDao {
	private static final String NS = "com.ssafy.happyhouse.model.dao.CityDao.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<gugunDto> selectGu(String city) {
		return sqlSession.selectList(NS+"selectGu",city);
	}

	@Override
	public List<DongDto> selectDong(String city,String gu) {
		System.out.println(city);
		System.out.println(gu);
		gugunDto dto = new gugunDto();
		dto.setCity(city);
		dto.setGugun(gu);
		return sqlSession.selectList(NS+"selectDong",dto);
	}

}
