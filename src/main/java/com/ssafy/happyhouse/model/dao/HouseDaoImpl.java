package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.Pair;
import com.ssafy.happyhouse.model.dto.Search2Dto;
import com.ssafy.happyhouse.model.dto.SearchDto;
import com.ssafy.happyhouse.util.DBUtil;

@Repository
public class HouseDaoImpl implements HouseDao{
	public HouseDaoImpl() {
	}
	public void loadData() { }
	private static final String NS = "com.ssafy.happyhouse.model.dao.HouseDao.";

	@Autowired
	private SqlSession sqlSession;

	public HouseDeal searchByNo(int no){
		return sqlSession.selectOne(NS + "searchByNo", no);
	}
	public List<HouseDeal> searchAll(Pair pa){
		int sizePerpage = pa.getY();
		int currentPage = (pa.getX()-1)*sizePerpage;
		Pair temppa = new Pair();
		temppa.setX(currentPage);
		temppa.setY(sizePerpage);
		return sqlSession.selectList(NS + "searchAll", temppa);
	}
	public int getTotalCount() {
		return sqlSession.selectOne(NS + "getTotalCount");
	}
	public List<HouseDeal>detaillist(SearchDto searchDto){
		Search2Dto temp = new Search2Dto();	
		String [] type=searchDto.getType();
		String searchType=searchDto.getSearchType();
		String searchword =searchDto.getSearchWord();
		String temptype=null;
		for(int i=1;i<5;i++) {
			if(type[i]!=null) {
				temptype=type[i];
			}
		}
		temp.setType(temptype);
		temp.setSearchType(searchType);
		temp.setSearchWord(searchword);
		System.out.println(searchword);
		return sqlSession.selectList(NS + "detaillist", temp);
	}
}




