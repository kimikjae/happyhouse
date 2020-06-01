package com.ssafy.happyhouse.model.dto;
import java.sql.Date;

//관심지역 
public class Interestlocation {

 // no 
 private Integer no;

 // 회원번호 
 private Integer memberno;

 // 법정동코드 
 private Integer dongcode;

 // 등록일시 
 private Date createdate;

 public Integer getNo() {
     return no;
 }

 public void setNo(Integer no) {
     this.no = no;
 }

 public Integer getMemberno() {
     return memberno;
 }

 public void setMemberno(Integer memberno) {
     this.memberno = memberno;
 }

 public Integer getDongcode() {
     return dongcode;
 }

 public void setDongcode(Integer dongcode) {
     this.dongcode = dongcode;
 }

 public Date getCreatedate() {
     return createdate;
 }

 public void setCreatedate(Date createdate) {
     this.createdate = createdate;
 }

 // Interestlocation 모델 복사
 public void CopyData(Interestlocation param)
 {
     this.no = param.getNo();
     this.memberno = param.getMemberno();
     this.dongcode = param.getDongcode();
     this.createdate = param.getCreatedate();
 }
}