package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.InteractionDto;


@Repository
public class InterestLocationDaoImpI implements InterestlocationDao {
	private final static String NS = "com.ssafy.happyhouse.model.dao.InterestlocationDao.";

	@Autowired
	private SqlSession sqlSession;
	@Override
	public void insertLocation(InteractionDto interDto) {
		sqlSession.insert(NS+"insertLocation",interDto);
	}



}

