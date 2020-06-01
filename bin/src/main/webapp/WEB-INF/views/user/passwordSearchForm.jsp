<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.backsize {
	margin-top: 30px;
	width: 20%;
}

.background1 {
	height: 200px;
	background-color: #BDBDBD;
	margin-top: 30px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div align="center">
		<h2>비밀번호 찾기</h2>
		<div class="background1">
			<form method="post" action="<c:url value="/user.do"/>">
				<input type="hidden" name="act" value="passwordSearch" />
				<div class="backsize">
					<table class="table table-hover table-primary">
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" /></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" /></td>
						</tr>
					</table>
					<button class="btn btn-primary">찾기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>