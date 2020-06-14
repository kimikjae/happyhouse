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
		gugunDto dto = new gugunDto();
		dto.setCity(city);
		dto.setGugun(gu);
		return sqlSession.selectList(NS+"selectDong",dto);
	}

	@Override
	public List<DongDto> selectAll() {
		return sqlSession.selectList(NS+"selectAll");
	}

	@Override
	public DongDto selectLocation(String city, String gu, String dong) {
		DongDto dto = new DongDto();
		dto.setCity(city);
		dto.setGugun(gu);
		dto.setDong(dong);
		return sqlSession.selectOne(NS+"selectLocation",dto);
	}

	@Override
	public List<DongDto> selectList(String city, String gu, String dong) {
		DongDto dto = new DongDto();
		dto.setCity(city);
		dto.setGugun(gu);
		dto.setDong(dong);
		DongDto temp =selectDongCode(dto.getCity(),dto.getGugun(),dto.getDong());
		int dongcode = temp.getDongcode();
		System.out.println(dongcode);
		DongDto temp2=new DongDto();
		temp2.setDong(" "+dong);
		temp2.setCode(dongcode);
		return sqlSession.selectList(NS+"selectList",temp2);
	}
	@Override
	public DongDto selectDongCode(String city, String gu, String dong) {
		DongDto dto = new DongDto();
		dto.setCity(city);
		dto.setGugun(gu);
		dto.setDong(dong);
		return sqlSession.selectOne(NS+"selectDongCode",dto);
	}

}
