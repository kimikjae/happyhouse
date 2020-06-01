package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.CommercialData;
import com.ssafy.happyhouse.util.DBUtil;

public class CommercialDataDAO {
	
	private List<CommercialData> list;
	
	
	public CommercialDataDAO() {
		list = new ArrayList<CommercialData>();
	}



	public void insertData(CommercialData data) {
		
	}
	
	
	
	public List<CommercialData> searchAll(){
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from commercial_data ";
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				CommercialData temp = new CommercialData();
				temp.setShopname(rs.getString("Shopname"));
				temp.setLocalname(rs.getString("Localname"));
				temp.setCode1(rs.getString("code1"));
				temp.setCodename1(rs.getString("Codename1"));
				temp.setCode2(rs.getString("Code2"));
				temp.setCodename2(rs.getString("Codename2"));
				temp.setCode3(rs.getString("Code3"));
				temp.setCodename3(rs.getString("Codename3"));
				temp.setCode4(rs.getString("Code4"));
				temp.setCodename4(rs.getString("Codename4"));
				temp.setCitycode(rs.getString("Citycode"));
				temp.setCity(rs.getString("City"));
				temp.setGucode(rs.getString("setGucode"));
				temp.setGu(rs.getString("setGu"));
				temp.setDongcode(rs.getInt("Dongcode"));
				temp.setDong(rs.getString("Dong"));
				temp.setJibuaddress(rs.getString("Jibuaddress"));
				temp.setAddress(rs.getString("Address"));
				temp.setOldpostcode(rs.getString("Oldpostcode"));
				temp.setPostcode(rs.getString("Postcode"));
				temp.setLng(rs.getString("Lng"));
				temp.setLat(rs.getString("Lat"));
				list.add(temp);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(connection);
		}
		return null;
	}
	
	public CommercialData searchByNo(int no) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from commercial_data "
					+ " where no = ? ";
			stmt = connection.prepareStatement(sql);
			int idx = 1;
			stmt.setInt(idx, no);
			
			rs = stmt.executeQuery();
			CommercialData temp = new CommercialData();
			if(rs.next()) {
				temp.setShopname(rs.getString("Shopname"));
				temp.setLocalname(rs.getString("Localname"));
				temp.setCode1(rs.getString("code1"));
				temp.setCodename1(rs.getString("Codename1"));
				temp.setCode2(rs.getString("Code2"));
				temp.setCodename2(rs.getString("Codename2"));
				temp.setCode3(rs.getString("Code3"));
				temp.setCodename3(rs.getString("Codename3"));
				temp.setCode4(rs.getString("Code4"));
				temp.setCodename4(rs.getString("Codename4"));
				temp.setCitycode(rs.getString("Citycode"));
				temp.setCity(rs.getString("City"));
				temp.setGucode(rs.getString("setGucode"));
				temp.setGu(rs.getString("setGu"));
				temp.setDongcode(rs.getInt("Dongcode"));
				temp.setDong(rs.getString("Dong"));
				temp.setJibuaddress(rs.getString("Jibuaddress"));
				temp.setAddress(rs.getString("Address"));
				temp.setOldpostcode(rs.getString("Oldpostcode"));
				temp.setPostcode(rs.getString("Postcode"));
				temp.setLng(rs.getString("Lng"));
				temp.setLat(rs.getString("Lat"));
			}
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(connection);
		}
		return null;
	}
	public List<CommercialData> search(String shopname) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from commercial_data "
					+ " where shopname = ? ";
			stmt = connection.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx, shopname);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				CommercialData temp = new CommercialData();
				temp.setShopname(rs.getString("Shopname"));
				temp.setLocalname(rs.getString("Localname"));
				temp.setCode1(rs.getString("code1"));
				temp.setCodename1(rs.getString("Codename1"));
				temp.setCode2(rs.getString("Code2"));
				temp.setCodename2(rs.getString("Codename2"));
				temp.setCode3(rs.getString("Code3"));
				temp.setCodename3(rs.getString("Codename3"));
				temp.setCode4(rs.getString("Code4"));
				temp.setCodename4(rs.getString("Codename4"));
				temp.setCitycode(rs.getString("Citycode"));
				temp.setCity(rs.getString("City"));
				temp.setGucode(rs.getString("setGucode"));
				temp.setGu(rs.getString("setGu"));
				temp.setDongcode(rs.getInt("Dongcode"));
				temp.setDong(rs.getString("Dong"));
				temp.setJibuaddress(rs.getString("Jibuaddress"));
				temp.setAddress(rs.getString("Address"));
				temp.setOldpostcode(rs.getString("Oldpostcode"));
				temp.setPostcode(rs.getString("Postcode"));
				temp.setLng(rs.getString("Lng"));
				temp.setLat(rs.getString("Lat"));
				list.add(temp);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(connection);
		}
		
		
		
		return null;
	}
	public List<CommercialData> search(Integer dongcode) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from commercial_data "
					+ " where dongcode = ? ";
			stmt = connection.prepareStatement(sql);
			int idx = 1;
			stmt.setInt(idx, dongcode);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				CommercialData temp = new CommercialData();
				temp.setShopname(rs.getString("Shopname"));
				temp.setLocalname(rs.getString("Localname"));
				temp.setCode1(rs.getString("code1"));
				temp.setCodename1(rs.getString("Codename1"));
				temp.setCode2(rs.getString("Code2"));
				temp.setCodename2(rs.getString("Codename2"));
				temp.setCode3(rs.getString("Code3"));
				temp.setCodename3(rs.getString("Codename3"));
				temp.setCode4(rs.getString("Code4"));
				temp.setCodename4(rs.getString("Codename4"));
				temp.setCitycode(rs.getString("Citycode"));
				temp.setCity(rs.getString("City"));
				temp.setDongcode(rs.getInt("Dongcode"));
				temp.setDong(rs.getString("Dong"));
				temp.setJibuaddress(rs.getString("Jibuaddress"));
				temp.setAddress(rs.getString("Address"));
				temp.setOldpostcode(rs.getString("Oldpostcode"));
				temp.setPostcode(rs.getString("Postcode"));
				temp.setLng(rs.getString("Lng"));
				temp.setLat(rs.getString("Lat"));
				list.add(temp);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(connection);
		}
		
		
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		CommercialDataDAO a = new CommercialDataDAO();
		
//		a.search(HouseDaoImpl.getDongCode("평동")).forEach(System.out::println);
		
	}
}

