package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.MemberDao;
import com.ssafy.happyhouse.model.dao.MemberDaoIpmI;
import com.ssafy.happyhouse.model.dto.MemberDto;
@Service
public class MemberServiceIpmI implements MemberService {
	private MemberDao dao;
	public MemberServiceIpmI() {
		dao = new MemberDaoIpmI();
	}
	public void signup(MemberDto memberdto) {
		try {
			dao.insertMember(memberdto);
			System.out.println(memberdto.getId() + "등록완료");
		} catch (Exception e) {
			throw new HappyHouseException("회원 가입시 오류 발생.");
		}
	}

	@Override
	public MemberDto login(String id, String password) {
		if(id == null || password == null) {
			return null;
		}
		try {
			return dao.login(id, password);

		} catch (SQLException e) {
			throw new HappyHouseException("login 오류 발생");
		}
	}

	public void update(MemberDto member) {
		try {
			System.out.println("service update");
			dao.updateMember(member);
		} catch (Exception e) {
			throw new HappyHouseException("수정 오류발생");
		}
	}
	@Override
	public void delete(MemberDto member) {
		try {
			System.out.println("service delete");
			dao.deleteMember(member);
		}catch(Exception e) {
			throw new HappyHouseException("삭제 오류발생");
		}
	}
	@Override
	public String search(String id) {
		try {
			MemberDto m = dao.searchMember(id);
			String pw= m.getPassword();
			return pw;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
