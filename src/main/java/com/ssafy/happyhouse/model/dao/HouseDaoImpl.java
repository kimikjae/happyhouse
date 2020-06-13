package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.Pair;

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
	public List<HouseDeal>detaillist(String searchWord){

		return sqlSession.selectList(NS + "detaillist", searchWord);
	}
}




