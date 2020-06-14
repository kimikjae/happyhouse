package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
