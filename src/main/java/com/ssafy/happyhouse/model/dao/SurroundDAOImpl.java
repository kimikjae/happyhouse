package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.CommercialData;
import com.ssafy.happyhouse.model.dto.DongDto;

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
	@Override
	public DongDto selectByNo(int no) {
		System.out.println("bb");
		return sqlSession.selectOne(NS+"selectByNo",no);
	}
	@Override
	public List<CommercialData> selectCodeName2(String codename1) {
		return  sqlSession.selectList(NS+"selectCodename2",codename1);
	}
	@Override
	public List<CommercialData> selectCodeName3(String codename2) {
		return  sqlSession.selectList(NS+"selectCodename3",codename2);
	}
	@Override
	public List<CommercialData> selectletlot(String codename1, String codename2, String codename3) {
		CommercialData dto= new CommercialData();
		dto.setCodename1(codename1);
		dto.setCodename2(codename2);
		dto.setCodename3(codename3);
		return sqlSession.selectList(NS+"selectletlot",dto);
	}

}
