package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.Pair;
import com.ssafy.happyhouse.model.dto.SearchDto;

public interface HouseDao {
   public void loadData();
   public HouseDeal searchByNo(int no); //
   public int getTotalCount() throws SQLException; // 
   public List<HouseDeal> searchAll(Pair pa); // 
   public List<HouseDeal> detaillist(SearchDto searchDto) throws SQLException;
}