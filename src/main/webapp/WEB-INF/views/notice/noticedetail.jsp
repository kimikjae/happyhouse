<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/notice/noticedetail.css"/> />
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h2 align="center">공지사항 상세</h2>
	<div class="tableDiv">
		<table class="table table-bordered">
			<tr>
				<th colspan="2">공지사항 게시글 정보</th>
			</tr>
			<tr>
				<th>글번호</th>
				<td>${notice.noticeno}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${notice.name}</td>
			</tr>
			<tr>
				<th>작성자 id</th>
				<td>${notice.id}</td>
			</tr>
			<tr>
				<th>작성 시간(수정시간)</th>
				<td>${notice.uploaddate}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${notice.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${notice.content}</td>
			</tr>
		</table>
	</div>
	<div class="tableDiv">
		<ul class="nav nav-fill nav-pills justify-content-center">
			<li class="nav-item li-padding"><a class="nav-link active"
				href="<c:url value="/notice/noticelist"/>">
					공지목록으로 돌아가기 </a></li>
			<li class="nav-item li-padding"><a class="nav-link active"
				href="<c:url value="/notice/noticedelete?noticeno=${notice.noticeno}"/>">
					공지삭제 </a></li>
			<li class="nav-item"><a class="nav-link active"
				href="<c:url value="/notice/noticeupdate?noticeno=${notice.noticeno }"/>"> 공지수정 </a></li>
		</ul>
	</div>
</body>
</html>