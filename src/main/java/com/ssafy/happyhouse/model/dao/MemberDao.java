package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;

import com.ssafy.happyhouse.model.dto.MemberDto;

public interface MemberDao {

   void insertMember(MemberDto member);
   public MemberDto searchMember(String id) throws SQLException;
   void updateMember(MemberDto member);
   void deleteMember(MemberDto member);
   public MemberDto login(MemberDto memberDto) throws SQLException;

}
