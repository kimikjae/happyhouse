package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.util.DBUtil;

public class MemberDaoIpmI implements MemberDao{

   @Override
   public void insertMember(MemberDto member) {
      Connection con = null;
      PreparedStatement stmt = null;
      try {
         con = DBUtil.getConnection();
         StringBuilder sql = new StringBuilder();
         sql.append(" insert into member( id, password, name, address1, phonenumber ) ");
         sql.append("values ( ?, ?, ?, ?, ? )");
         stmt = con.prepareStatement(sql.toString());
         int idx = 1;
         stmt.setString(idx++, member.getId());
         stmt.setString(idx++, member.getPassword());
         stmt.setString(idx++, member.getName());
         stmt.setString(idx++, member.getAddress1());
         stmt.setString(idx++, member.getPhonenumber());
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
   public MemberDto searchMember(String id) throws SQLException {
      Connection con = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      try {
         con = DBUtil.getConnection();
         StringBuilder sql = new StringBuilder();
         sql.append("select * ");
         sql.append("from member ");
         sql.append("where id = ? ");
         stmt = con.prepareStatement(sql.toString());
         stmt.setString(1, id);
         rs = stmt.executeQuery();
         if(rs.next()) {
            MemberDto m=new MemberDto();
            m.setNo(rs.getInt("no"));
            m.setId(rs.getString("id"));
            m.setPassword(rs.getString("password"));
            m.setDate(rs.getTimestamp("date"));
            m.setEmail(rs.getString("email"));
            m.setPhonenumber(rs.getString("phonenumber"));
            m.setName(rs.getString("name"));
            m.setAddress1(rs.getString("address1"));
            m.setAddress2(rs.getString("address2"));
            m.setPostnumber(rs.getString("postnumber"));
            return m;
         }
         return null;
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

   @Override
   public void updateMember(MemberDto member) { //password수정
      Connection con = null;
      PreparedStatement stmt = null;
      try {
         con = DBUtil.getConnection();
         StringBuilder sql = new StringBuilder();
         sql.append("update member ");
         sql.append("set password = ?, name = ?, address1 = ?, phonenumber = ? ");
         sql.append("where no = ? ");
         stmt = con.prepareStatement(sql.toString());
         int idx = 1;
         stmt.setString(idx++, member.getPassword());
         stmt.setString(idx++, member.getName());
         stmt.setString(idx++, member.getAddress1());
         stmt.setString(idx++, member.getPhonenumber());
         stmt.setInt(idx++, member.getNo());
         stmt.executeUpdate();
      }catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         DBUtil.close(stmt);
         DBUtil.close(con);
      }
   }

   @Override// id password 입력시 회원정보 삭제
   public void deleteMember(MemberDto member) {
      Connection con = null;
      PreparedStatement stmt = null;
      try {
         con = DBUtil.getConnection();
         String sql = " delete from member where id=? and password=? ";
         stmt = con.prepareStatement(sql.toString());
         int idx = 1;
         stmt.setString(idx++, member.getId());
         stmt.setString(idx++, member.getPassword());
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
public MemberDto login(String id, String password) throws SQLException {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	MemberDto m;
	try{
		con = DBUtil.getConnection();
		String sql = new String();
		sql="select no,date,email,phonenumber,name,address1,address2,postnumber from member where id=? and password = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setString(2, password);
		rs = stmt.executeQuery();
		if (rs.next()) {
			m=new MemberDto();
			m.setId(id);
			m.setPassword(password);
			m.setNo(rs.getInt("no"));
			m.setDate(rs.getTimestamp("date"));
			m.setEmail(rs.getString("email"));
			m.setPhonenumber(rs.getString("phonenumber"));
			m.setName(rs.getString("name"));
			m.setAddress1(rs.getString("address1"));
			m.setAddress2(rs.getString("address2"));
			m.setPostnumber(rs.getString("postnumber"));
			return m;
		}

	} finally {
		DBUtil.close(rs);
		DBUtil.close(stmt);
		DBUtil.close(con);
	}
	return null;
}

   
   
   
}
