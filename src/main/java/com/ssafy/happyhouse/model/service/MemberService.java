package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.MemberDto;

public interface MemberService {
   void signup(MemberDto member);//member을 등록
   MemberDto login(String id, String password);  //해당 id member찾기
   void update(MemberDto member); // pw 수정
   void delete(MemberDto member);
   String search(String id);
}