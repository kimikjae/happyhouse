<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.first {
	margin-top: 30px;
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
	<div class="first" align="center">
	<div class="background1">
	<h2>비밀 번호는 : ${pwd}입니다.</h2>
	<br><br><br><br><br>
	<a href="<c:url value="/user.do"/>">확인</a> 
	</div>
	</div>
	
</body>
</html>