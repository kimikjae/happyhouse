<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.tablesize {
	width: 20%;
}
.background1{
	margin-top: 30px;
	background-color : #BDBDBD;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div align="center">
		<h1>회원 정보 확인</h1>
		<div class="background1">
			<div class="tablesize">
				<table class="table table-hover table-primary">
					<tr>
						<td>아이디*</td>
						<td>${loginUser.id }</td>
					</tr>
					<tr>
						<td>비밀번호*</td>
						<td>${loginUser.password }</td>
					</tr>
					<tr>
						<td>이름*</td>
						<td>${loginUser.name }</td>
					</tr>
					<tr>
						<td>주소*</td>
						<td>${loginUser.address1 }</td>
					</tr>
					<tr>
						<td>전화번호*</td>
						<td>${loginUser.phonenumber }</td>
					</tr>
				</table>
			</div>
		</div>
		<a class="btn btn-primary" href="<c:url value="/user.do"/>" role="button">확인</a> <a
			class="btn btn-primary" href="<c:url value="/user.do?act=modifyForm"/>" role="button">수정</a> <a
			class="btn btn-primary" href="<c:url value="/user.do?act=delete"/>" role="button">탈퇴</a>
	</div>
</body>
</html>