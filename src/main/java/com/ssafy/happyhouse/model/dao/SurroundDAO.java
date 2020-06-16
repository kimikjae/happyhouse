package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.dto.DongDto;

public interface SurroundDAO {
	public void delete(int no);
	DongDto selectByNo(int no);
}
