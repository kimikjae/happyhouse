<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.background1{
	margin-top: 30px;
	background-color : #BDBDBD;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp"%>
<div align="center">
	<h2>탈퇴 되었습니다.</h2>
	<div class="background1">
	<a class="btn btn-primary" href="<c:url value="/"/>" role="button">확인</a>
	</div>
</div>
</body>
</html>