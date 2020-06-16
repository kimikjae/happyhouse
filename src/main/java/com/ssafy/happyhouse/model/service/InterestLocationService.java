package com.ssafy.happyhouse.model.service;

import java.io.IOException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.InteractionDto;

public interface InterestLocationService {
	void registLocation(InteractionDto interDto);
	List<InteractionDto> selectlist(String id)throws IOException ;
}

