package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.InteractionDto;


public interface InterestlocationDao {
	void insertLocation(InteractionDto interDto);
	List<InteractionDto>selectlist(String id);
}

