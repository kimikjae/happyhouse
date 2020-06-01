package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Interestlocation;
import com.ssafy.happyhouse.model.dto.MemberDto;

public interface InterestLocationService {
	/**
	 * 
	 * @param location
	 */
	void registLocation(Interestlocation location);
	/**
	 * 
	 * @param location
	 */
	void deleteLocation(Interestlocation location);
	/**
	 * 
	 * @param member
	 * @return	Interestlocation list
	 */
	List<Interestlocation> getLocationsByMember(MemberDto member);
}

