package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.util.DBUtil;
	
// 필요없는 클래스
public class HouseInfoDaoImpl implements HouseInfoDao {

	List<HouseInfo> list;
	
	@Override
	public List<HouseInfo> searchAllHouseInfo() throws SQLException {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select * from houseinfo ");
			stmt = con.prepareStatement(sql.toString());
			
			rs = stmt.executeQuery();
			list = new LinkedList<>();
			while(rs.next()) {
				HouseInfo house = new HouseInfo();
				house.setNo(rs.getInt("no"));
				house.setDong ( rs.getString("dong"));
				house.setAptName (rs.getString("aptname"));
				house.setCode(rs.getInt("code"));
				house.setBuildYear(rs.getInt("BuildYear"));
				house.setJibun(rs.getString("jibun"));
				list.add(house);
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
	
	public HouseInfo searchHouseInfo(int no) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select * from houseinfo ");
			sql.append(" where no = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			if(rs.next()) {
				HouseInfo house = new HouseInfo();
				house.setNo(rs.getInt("no"));
				house.setDong ( rs.getString("dong"));
				house.setAptName (rs.getString("aptname"));
				house.setCode(rs.getInt("code"));
				house.setBuildYear(rs.getInt("BuildYear"));
				house.setJibun(rs.getString("jibun"));
				return house;
			}
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

	public HouseInfo searchHouseInfo(String dong, String Aptname) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select * from houseinfo ");
			sql.append(" where dong = ? and aptname = ? ");
			stmt = con.prepareStatement(sql.toString());
			int idx = 1;
			stmt.setString(idx++, dong);
			stmt.setString(idx++, Aptname);
			rs = stmt.executeQuery();
			if(rs.next()) {
				HouseInfo house = new HouseInfo();
				house.setNo(rs.getInt("no"));
				house.setDong ( rs.getString("dong"));
				house.setAptName (rs.getString("aptname"));
				house.setCode(rs.getInt("code"));
				house.setBuildYear(rs.getInt("BuildYear"));
				house.setJibun(rs.getString("jibun"));
				return house;
			}
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

