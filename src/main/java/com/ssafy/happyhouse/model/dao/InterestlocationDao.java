package com.ssafy.happyhouse.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.InteractionDto;


public interface InterestlocationDao {
	void insertLocation(InteractionDto interDto);
	List<InteractionDto> selectInterestionById(String memberid) throws IOException;
}

