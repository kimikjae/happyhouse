package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.Pair;
import com.ssafy.happyhouse.model.dto.Trio;

public interface HouseDao {
   public void loadData();
   public HouseDeal searchByNo(int no); //
   public int getTotalCount(); //
   public int getTotalCountBySearchWord(String searchWord);
   public List<HouseDeal> searchAll(Pair pa); // 
   public List<HouseDeal>detaillist(Trio t);
}