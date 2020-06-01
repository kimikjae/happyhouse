package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.MemberDto;

@Repository
public class MemberDaoIpmI implements MemberDao{
	private final static String NS = "com.ssafy.happyhouse.model.dao.MemberDao.";

	@Autowired
	private SqlSession sqlSession;


	@Override
	public void insertMember(MemberDto member) {
		sqlSession.insert(NS + "insertMember",member);
	}

	@Override
	public MemberDto searchMember(String id) throws SQLException {
		return sqlSession.selectOne(NS+"searchMember",id);
	}

	@Override
	public void updateMember(MemberDto member) { //password수정
		sqlSession.update(NS + "updateMember",member);
	}

	@Override// id password 입력시 회원정보 삭제
	public void deleteMember(MemberDto member) {
		sqlSession.delete(NS + "deleteMember",member);
	}

	@Override
	public MemberDto login(MemberDto memberDto) throws SQLException {
		return sqlSession.selectOne(NS + "login",memberDto);
	}
}
