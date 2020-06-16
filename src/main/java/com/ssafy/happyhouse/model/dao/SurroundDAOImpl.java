package com.ssafy.happyhouse.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SurroundDAOImpl implements SurroundDAO{
private static final String NS = "com.ssafy.happyhouse.model.dao.SurroundDAO.";
	
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void delete(int no) {
		System.out.println("aa");
		sqlSession.delete(NS+"delete",no);
	}

}
