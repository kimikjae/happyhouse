package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.Pair;
import com.ssafy.happyhouse.model.dto.Trio;

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
	public int getTotalCountBySearchWord(String searchWord) {
		return sqlSession.selectOne(NS + "getTotalCountBySearchWord", searchWord);
	}
	public List<HouseDeal>detaillist(Trio t){
		int sizePerpage = t.getY();
		int currentPage = (t.getX()-1)*sizePerpage;
		Trio tempt = new Trio();
		tempt.setX(currentPage);
		tempt.setY(sizePerpage);
		tempt.setStr(t.getStr());
		return sqlSession.selectList(NS + "detaillist", tempt);
	}
}




