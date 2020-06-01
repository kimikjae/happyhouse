<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<style>
.tablesize {
	width: 20%;
}

.background1 {
	margin-top: 30px;
	background-color: #BDBDBD;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div align="center">
		<form method="post" action="<c:url value="/user.do"/>">
			<input type="hidden" name="act" value="register">
			<h3>회원 가입</h3>
			<div class="background1">
				<div class="tablesize">
					<table class="table table-hover table-primary">
						<tr>
							<td>아이디*</td>
							<td><input type="text" name="id" /></td>
						</tr>
						<tr>
							<td>비밀번호*</td>
							<td><input type="password" name="password"
								placeholder="영문 숫자 포함 6자리 이상" /></td>
						</tr>
						<tr>
							<td>이름*</td>
							<td><input type="text" name="name" placeholder="User Name" /></td>
						</tr>
						<tr>
							<td>주소*</td>
							<td><input type="text" name="address1" placeholder="address" /></td>
						</tr>
						<tr>
							<td>전화번호*</td>
							<td><input type="text" name="phonenumber"
								placeholder="010-xxxx-xxxx" /></td>
						</tr>
					</table>
				</div>
			</div>
			<button class="btn btn-primary">등록</button>
		</form>
	</div>
</body>
</html>