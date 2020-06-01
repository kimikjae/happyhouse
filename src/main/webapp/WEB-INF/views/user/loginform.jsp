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

.background1 {
	margin-top: 30px;
	background-color: #BDBDBD;
}

.btn-dark {
	align: center;
	float: left;
	margin-left:40px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div align="center">
		<form method="post" action="<c:url value="/user/login"/>">
			<div class="background1">
				<div class="tablesize">
					<table class="table table-hover table-primary">
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" /></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="password" name="password" /></td>
						</tr>
					</table>
					<button class="btn btn-primary">로그인</button>
					<a class="btn btn-primary"
						href="<c:url value="/user/passwordsearchform"/>"
						role="button">비밀번호찾기</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>