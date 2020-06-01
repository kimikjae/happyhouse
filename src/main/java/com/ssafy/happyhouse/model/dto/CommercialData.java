package com.ssafy.happyhouse.model.dto;
//상권정보 
public class CommercialData {

 // 상가업소번호 
 private Integer no;

 // 상호명 
 private String shopname;

 // 지점명 
 private String localname;

 // 상권업종대분류코드 
 private String code1;

 // 상권업종대분류명 
 private String codename1;

 // 상권업종중분류코드 
 private String code2;

 // 상권업종중분류명 
 private String codename2;

 // 상권업종소분류코드 
 private String code3;

 // 상권업종소분류명 
 private String codename3;

 // 표준상업분류코드 
 private String code4;

 // 표준산업분류명 
 private String codename4;

 // 시도코드 
 private String citycode;

 // 시도명 
 private String city;

 // 시군구코드 
 private String gucode;

 // 시군구명 
 private String gu;

 // 법정동코드 
 private Integer dongcode;

 // 법정동명 
 private String dong;

 // 지번주소 
 private String jibuaddress;

 // 주소 
 private String address;

 // 예전우편번호 
 private String oldpostcode;

 // 우변번호 
 private String postcode;

 // 경도 
 private String lng;

 // 위도 
 private String lat;

 public Integer getNo() {
     return no;
 }

 public void setNo(Integer no) {
     this.no = no;
 }

 public String getShopname() {
     return shopname;
 }

 public void setShopname(String shopname) {
     this.shopname = shopname;
 }

 public String getLocalname() {
     return localname;
 }

 public void setLocalname(String localname) {
     this.localname = localname;
 }

 public String getCode1() {
     return code1;
 }

 public void setCode1(String code1) {
     this.code1 = code1;
 }

 public String getCodename1() {
     return codename1;
 }

 public void setCodename1(String codename1) {
     this.codename1 = codename1;
 }

 public String getCode2() {
     return code2;
 }

 public void setCode2(String code2) {
     this.code2 = code2;
 }

 public String getCodename2() {
     return codename2;
 }

 public void setCodename2(String codename2) {
     this.codename2 = codename2;
 }

 public String getCode3() {
     return code3;
 }

 public void setCode3(String code3) {
     this.code3 = code3;
 }

 public String getCodename3() {
     return codename3;
 }

 public void setCodename3(String codename3) {
     this.codename3 = codename3;
 }

 public String getCode4() {
     return code4;
 }

 public void setCode4(String code4) {
     this.code4 = code4;
 }

 public String getCodename4() {
     return codename4;
 }

 public void setCodename4(String codename4) {
     this.codename4 = codename4;
 }

 public String getCitycode() {
     return citycode;
 }

 public void setCitycode(String citycode) {
     this.citycode = citycode;
 }

 public String getCity() {
     return city;
 }

 public void setCity(String city) {
     this.city = city;
 }

 public String getGucode() {
     return gucode;
 }

 public void setGucode(String gucode) {
     this.gucode = gucode;
 }

 public String getGu() {
     return gu;
 }

 public void setGu(String gu) {
     this.gu = gu;
 }

 public Integer getDongcode() {
     return dongcode;
 }

 public void setDongcode(Integer dongcode) {
     this.dongcode = dongcode;
 }

 public String getDong() {
     return dong;
 }

 public void setDong(String dong) {
     this.dong = dong;
 }

 public String getJibuaddress() {
     return jibuaddress;
 }

 public void setJibuaddress(String jibuaddress) {
     this.jibuaddress = jibuaddress;
 }

 public String getAddress() {
     return address;
 }

 public void setAddress(String address) {
     this.address = address;
 }

 public String getOldpostcode() {
     return oldpostcode;
 }

 public void setOldpostcode(String oldpostcode) {
     this.oldpostcode = oldpostcode;
 }

 public String getPostcode() {
     return postcode;
 }

 public void setPostcode(String postcode) {
     this.postcode = postcode;
 }

 public String getLng() {
     return lng;
 }

 public void setLng(String lng) {
     this.lng = lng;
 }

 public String getLat() {
     return lat;
 }

 public void setLat(String lat) {
     this.lat = lat;
 }

 // CommercialData 모델 복사
 public void CopyData(CommercialData param)
 {
     this.no = param.getNo();
     this.shopname = param.getShopname();
     this.localname = param.getLocalname();
     this.code1 = param.getCode1();
     this.codename1 = param.getCodename1();
     this.code2 = param.getCode2();
     this.codename2 = param.getCodename2();
     this.code3 = param.getCode3();
     this.codename3 = param.getCodename3();
     this.code4 = param.getCode4();
     this.codename4 = param.getCodename4();
     this.citycode = param.getCitycode();
     this.city = param.getCity();
     this.gucode = param.getGucode();
     this.gu = param.getGu();
     this.dongcode = param.getDongcode();
     this.dong = param.getDong();
     this.jibuaddress = param.getJibuaddress();
     this.address = param.getAddress();
     this.oldpostcode = param.getOldpostcode();
     this.postcode = param.getPostcode();
     this.lng = param.getLng();
     this.lat = param.getLat();
 }

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("CommercialData [no=");
	builder.append(no);
	builder.append(", shopname=");
	builder.append(shopname);
	builder.append(", city=");
	builder.append(city);
	builder.append(", gu=");
	builder.append(gu);
	builder.append(", dong=");
	builder.append(dong);
	builder.append(", address=");
	builder.append(address);
	builder.append(", postcode=");
	builder.append(postcode);
	builder.append(", lng=");
	builder.append(lng);
	builder.append(", lat=");
	builder.append(lat);
	builder.append("]");
	return builder.toString();
}
 
}

