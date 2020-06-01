package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Interestlocation;
import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.util.DBUtil;

public class InterestLocationDaoImpI implements InterestlocationDao {
	
	@Override
	public void insertLocation(Interestlocation location) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into interestlocation( memberno, dongcode, createdate ) ");
			sql.append("values ( ?, ?, ? )");
			stmt = con.prepareStatement(sql.toString());
			int idx = 1;
			stmt.setInt(idx++, location.getMemberno());
			stmt.setInt(idx++, location.getDongcode());
			java.util.Date d = new java.util.Date();
			String string = String.format("%d-%d-%d", d.getYear()+1900, d.getMonth(), d.getDay());
			stmt.setString(idx++, string);
			stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	@Override
	public int deleteLocation(Integer memberno, Integer dongcode) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" delete from interestlocation ");
			sql.append(" where memberno = ? and dongcode = ? ");
			stmt = con.prepareStatement(sql.toString());
			int idx = 1;
			stmt.setInt(idx++, memberno);
			stmt.setInt(idx++, dongcode);
			int rs = stmt.executeUpdate();
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return 0;
	}
	
	@Override
	public List<Interestlocation> getLocations(MemberDto member) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from interestlocation ");
			sql.append(" where memberno = ?");
			stmt = con.prepareStatement(sql.toString());
			int idx = 1;
			stmt.setInt(idx++, member.getNo());
			rs = stmt.executeQuery();
			List<Interestlocation> list = new ArrayList<Interestlocation>();
			
			while(rs.next()) {
				Interestlocation item = new Interestlocation();
				item.setDongcode(rs.getInt("dongcode"));
				item.setNo(rs.getInt("no"));
				item.setMemberno(rs.getInt("memberno"));
				item.setCreatedate(rs.getDate("createdate"));
				list.add(item);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}


}

