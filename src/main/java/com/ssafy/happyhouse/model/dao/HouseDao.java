package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.model.dto.SearchDto;

public interface HouseDao {
	public void loadData();
	public List<HouseDeal> searchAll(HousePageBean  bean) throws SQLException;
	public HouseDeal searchByNo(int no) throws SQLException;
	public List<HouseDeal> searchAll() throws SQLException;
	public int getTotalCount() throws SQLException;
	public List<HouseDeal> searchAll(int currentPage, int sizePerPage) throws SQLException;
	public List<HouseDeal> searchAll(SearchDto searchDto) throws SQLException;
}
