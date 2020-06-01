package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao {



	@Override
	public List<NoticeDto> listArticle(String key, String word) throws SQLException {
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select noticeno, id, name, subject, content, uploaddate \n");
			sql.append("from notice \n");
			if (!word.isEmpty()) {
				if ("subject".equals(key)) {
					sql.append("where subject like ? \n");
				} else {
					sql.append("where " + key + " = ? \n");
				}
			}
			sql.append("order by noticeno desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			if (!word.isEmpty()) {
				if ("subject".equals(key))
					pstmt.setString(1, "%" + word + "%");
				else
					pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NoticeDto noticeDto = new NoticeDto();
				noticeDto.setNoticeno(rs.getInt("noticeno"));
				noticeDto.setId(rs.getString("id"));
				noticeDto.setName(rs.getString("name"));
				noticeDto.setSubject(rs.getString("subject"));
				noticeDto.setContent(rs.getString("content"));
				noticeDto.setUploaddate(rs.getString("uploaddate"));
				
				list.add(noticeDto);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public void insertNotice(NoticeDto noticeDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder insertMember = new StringBuilder();
			
			insertMember.append("insert into notice (id, name, subject, content, uploaddate) \n");
			insertMember.append("values ( ? , ? , ? , ? ,now() ) ");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, noticeDto.getId());
			pstmt.setString(2, noticeDto.getName());
			pstmt.setString(3, noticeDto.getSubject());
			pstmt.setString(4, noticeDto.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public NoticeDto selectNoticeByNoticeNo(int noticeno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select noticeno, id, name, subject, content, uploaddate \n "
					+" from notice " + 
					" where noticeno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				NoticeDto noticeDto = new NoticeDto();
				noticeDto.setNoticeno(rs.getInt("noticeno"));
				noticeDto.setId(rs.getString("id"));
				noticeDto.setName(rs.getString("name"));
				noticeDto.setSubject(rs.getString("subject"));
				noticeDto.setContent(rs.getString("content"));
				noticeDto.setUploaddate(rs.getString("uploaddate"));
				return noticeDto;
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public void updateNotice(NoticeDto noticeDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder insertMember = new StringBuilder();
			
			insertMember.append(" update notice set subject= ? , content= ? ,  uploaddate= now() where noticeno = ? " );
			pstmt = conn.prepareStatement(insertMember.toString());
			
			int index=1;
			pstmt.setString(index++, noticeDto.getSubject());
			pstmt.setString(index++, noticeDto.getContent());
			pstmt.setInt(index++, noticeDto.getNoticeno());
			
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public void deleteNotice(int noticeno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from notice where noticeno = ?";
			pstmt = conn.prepareStatement(sql);
			int index=1;
			pstmt.setInt(index++,  noticeno);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

}
