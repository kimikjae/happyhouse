<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h1>상세검색화면</h1>
	<table>

		<tr>
			<td>거래번호:</td>
			<td>${home.no}</td>
		</tr>
		<tr>
			<th>법정동명:</th>
			<td>${home.dong}</td>
		</tr>
		<tr>
			<th>아파트 이름:</th>
			<td>${home.aptName}</td>
		</tr>
		<tr>
			<th>법정동 코드:</th>
			<td>${home.code}</td>
		</tr>
		<tr>
			<th>건축연도:</th>
			<td>${home.buildYear}</td>
		</tr>
		<tr>
			<th>거래일:</th>
			<td>${home.dealYear}.${home.dealMonth}.${home.dealDay}</td>
		</tr>
		<tr>
			<th>면적:</th>
			<td>${home.area}</td>
		</tr>
		<tr>
			<th>층:</th>
			<td>${home.floor}</td>
		</tr>
		<tr>
			<th>지번:</th>
			<td>${home.jibun}</td>
		</tr>
		<tr>
			<th>거래타입:</th>
			<td>${home.type}</td>
		</tr>
		<tr>
			<th>월세:</th>
			<td>${home.rentMoney}</td>
		</tr>
		<tr>
			<th>매매:</th>
			<td>${home.dealAmount}</td>
		</tr>
	</table>
	<div>
		<img src="./img/${home.aptName}.jpg" alt="해당 집의 사진" /> <img
			src="./img/${home.aptName}.jfif" />
	</div>
	<form method="post" action="<c:url value="/house.do"/>">
		<input type="hidden" name="act" value="houselist" /> <input
			type="hidden" name="pg" value="1" />
		<button class="btn btn-secondary">목록으로 돌아가기</button>
	</form>
</body>
</html>