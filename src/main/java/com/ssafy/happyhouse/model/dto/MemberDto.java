package com.ssafy.happyhouse.model.dto;

import java.sql.Timestamp;

//회원 
public class MemberDto {
	// 회원번호 
	private Integer no;
	// 아이디 
	private String id;
	// 비밀번호 
	private String password;
	// 이름 
	private String name;
	// 핸드폰번호 
	private String phonenumber;
	// 가입일 
	private Timestamp date;
	// 기본주소 
	private String address1;
	// 상세주소 
	private String address2;
	// 우편번호 
	private String postnumber;
	// 이메일 
	private String email;
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPostnumber() {
		return postnumber;
	}
	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Member 모델 복사
	public void CopyData(MemberDto param)
	{
		this.no = param.getNo();
		this.id = param.getId();
		this.password = param.getPassword();
		this.name = param.getName();
		this.phonenumber = param.getPhonenumber();
		this.date = param.getDate();
		this.address1 = param.getAddress1();
		this.address2 = param.getAddress2();
		this.postnumber = param.getPostnumber();
		this.email = param.getEmail();
	}
}
