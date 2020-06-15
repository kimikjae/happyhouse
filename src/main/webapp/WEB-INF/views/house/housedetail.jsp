<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/house/housedetail.css"/> />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div align="center">
		<h1>상세 검색 화면</h1>
	</div>
	<div id="leftCenter" class="center">
		<div class="tableDiv">
			<table class="table table-bordered">
				<thead class="thead-light">
					<tr>
						<th>거래번호</th>
						<td>${home.no}</td>
					</tr>
					<tr>
						<th>법정동명</th>
						<td>${home.dong}</td>
					</tr>
					<tr>
						<th>아파트 이름</th>
						<td>${home.aptName}</td>
					</tr>
					<tr>
						<th>법정동 코드</th>
						<td>${home.code}</td>
					</tr>
					<tr>
						<th>건축연도</th>
						<td>${home.buildYear} 년</td>
					</tr>
					<tr>
						<th>거래일</th>
						<td>${home.dealYear} 년  ${home.dealMonth} 월  ${home.dealDay} 일</td>
					</tr>
					<tr>
						<th>면적</th>
						<td>${home.area}m<sup>2</sup></td>
					</tr>
					<tr>
						<th>층</th>
						<td>${home.floor} 층</td>
					</tr>
					<tr>
						<th>지번</th>
						<td>${home.jibun} 번지</td>
					</tr>
					<tr>
						<th>매매</th>
						<td>${home.dealAmount} 만원</td>
					</tr>
			</table>
		</div>
	</div>
	<div>
		
	</div>
	<div>
		<img src="${link}" alt="해당 집의 사진" id=aptimg/>
	</div>
	<form method="post" action="<c:url value="/house/houselist"/>" id=fff>
		<input type="hidden" name="act" value="houselist" /> <input
			type="hidden" name="pg" value="1" />
		<button class="btn btn-secondary">목록으로 돌아가기</button>
	</form>
</body>
</html>