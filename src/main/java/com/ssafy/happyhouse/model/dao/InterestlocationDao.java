package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Interestlocation;
import com.ssafy.happyhouse.model.dto.MemberDto;

public interface InterestlocationDao {
	/**
	 * 
	 * @param location
	 * @throws SQLException
	 */
	void insertLocation(Interestlocation location) throws SQLException;
	/**
	 * 
	 * @param memberno
	 * @param dongcode
	 * @return 
	 * @throws SQLException
	 */
	int deleteLocation(Integer memberno, Integer dongcode)throws SQLException;
	/**
	 * 
	 * @param member
	 * @return
	 */
	List<Interestlocation> getLocations(MemberDto member);
}

