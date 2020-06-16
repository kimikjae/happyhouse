package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.DongDto;

public interface SurroundService {
	void delete(int no);
	DongDto selectByNo(int no);
}
