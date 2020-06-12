package com.ssafy.happyhouse.model.service;

import java.io.IOException;
import java.util.List;


import com.ssafy.happyhouse.model.dto.NewsDto;

public interface NewsService {
	public List<NewsDto> retrieveNews() throws IOException;
}
