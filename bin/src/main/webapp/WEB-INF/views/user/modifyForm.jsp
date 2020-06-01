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
		<h1>회원 정보 수정</h1>
		<form method="post" action="<c:url value="/user.do"/>">
			<input type="hidden" name="act" value="modify">
			<div class="background1">
			<div class="tablesize">
			<table class="table table-hover table-primary">
				<tr>
					<td>아이디*</td>
					<td>${loginUser.id }</td>
				</tr>
				<tr>
					<td>비밀번호*</td>
					<td><input type="text" name="password"
						placeholder="${loginUser.password }" /></td>
				</tr>
				<tr>
					<td>이름*</td>
					<td><input type="text" name="name"
						placeholder="${loginUser.name }" /></td>
				</tr>
				<tr>
					<td>주소*</td>
					<td><input type="text" name="address1"
						placeholder="${loginUser.address1 }" /></td>
				</tr>
				<tr>
					<td>전화번호*</td>
					<td><input type="text" name="phonenumber"
						placeholder="${loginUser.phonenumber }" /></td>
				</tr>
			</table>
			</div>
			</div>
			<button class="btn btn-primary">수정</button>
		</form>
	</div>
</body>
</html>