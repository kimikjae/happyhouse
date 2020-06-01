package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dao.HouseDaoImpl;
import com.ssafy.happyhouse.model.dao.InterestLocationDaoImpI;
import com.ssafy.happyhouse.model.dao.InterestlocationDao;
import com.ssafy.happyhouse.model.dao.MemberDaoIpmI;
import com.ssafy.happyhouse.model.dto.Interestlocation;
import com.ssafy.happyhouse.model.dto.MemberDto;

public class InterestLocationServiceImpl implements InterestLocationService {

	
	private InterestlocationDao dao;
	public InterestLocationServiceImpl() {
		dao = new InterestLocationDaoImpI();
	}

	@Override
	public void registLocation(Interestlocation location) {
		try {
			dao.insertLocation(location);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Interestlocation> getLocationsByMember(MemberDto member) {
		return dao.getLocations(member);
	}
	
	@Override
	public void deleteLocation(Interestlocation location) {
		try {
			dao.deleteLocation(location.getMemberno(), location.getDongcode());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InterestLocationService a = new InterestLocationServiceImpl();
		Interestlocation location = new Interestlocation ();
		location.setMemberno(1);
//		location.setDongcode(HouseDaoImpl.getDongCode("평동"));
		
		a.registLocation(location);
		MemberDto temp = new MemberDto();
		temp.setNo(1);
		temp.setId("id1");
		temp.setPassword("pwd1");
		temp.setName("name1");
		a.getLocationsByMember(temp).forEach(System.out::println);
		
		a.deleteLocation(location);
	}
}

