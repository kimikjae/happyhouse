package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.model.dto.SearchDto;
import com.ssafy.happyhouse.util.PageNavigation;

public interface HouseService {
	public List<HouseDeal> detaillist(String searchWord) throws SQLException;

	public List<HouseDeal> searchAll(int pg, int sizePerPage) throws SQLException;

	public HouseDeal searchHouseByNo(int no);

	public PageNavigation makePageNavigation(int currentPage, int sizePerPage) throws SQLException;
}