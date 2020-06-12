package com.ssafy.happyhouse.model.dao;

import java.io.IOException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.NewsDto;

public interface NewsDAO {
	List<NewsDto> selectNews() throws IOException;
}
