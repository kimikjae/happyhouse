package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.dto.NoticeSearchDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	private static final String NS = "com.ssafy.happyhouse.model.dao.NoticeDao.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertNotice(NoticeDto noticeDto){
		return sqlSession.insert(NS + "insertNotice", noticeDto);
	}
	
	public List<NoticeDto> listArticle(String key, String word){
	
		if(word==null||word=="") {
			return sqlSession.selectList(NS+ "listArticleAll");
		}
		else {
			NoticeSearchDto noticeSearchDto = new NoticeSearchDto();
			noticeSearchDto.setKey(key);
			noticeSearchDto.setWord(word);
			System.out.println("key : "+key);
			System.out.println("word : "+word);
			return sqlSession.selectList(NS + "listArticle",noticeSearchDto);
		}
		
		
	}
	
	public NoticeDto selectNoticeByNoticeNo(int noticeno){
		return sqlSession.selectOne(NS + "selectNoticeByNoticeNo", noticeno);
	}
	
	public int updateNotice(NoticeDto noticeDto){
		return sqlSession.update(NS + "updateNotice", noticeDto);
	}
	
	public int deleteNotice(int noticeno){
		return sqlSession.delete(NS + "deleteNotice", noticeno);
	}

	@Override
	public List<NoticeDto> selectAll() throws SQLException {
		return sqlSession.selectList(NS + "selectAll");
	}
}
