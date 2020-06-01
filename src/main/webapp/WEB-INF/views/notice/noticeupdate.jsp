<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>글수정</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href=<c:url value="/notice/noticeupdate.css"/> />
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<c:choose>
		<c:when test="${empty loginUser}">
			<h2 align="center">로그인이 필요합니다</h2>
			<div>
				<form method="post" action="<c:url value="/user.do"/>">
					<input type="hidden" name="act" value="registerForm">
					<button>회원 가입</button>
				</form>
				<form method="post" action="<c:url value="/user.do"/>">
					<input type="hidden" name="act" value="loginForm">
					<button>로그인</button>
				</form>
				<a href="<c:url value="/user.do"/>">Home</a> <a
					href="<c:url value="/notice.do?act=noticelist"/>">Back</a>
			</div>
		</c:when>
		<c:otherwise>
			<h2 align="center">글수정</h2>
			<div class="container" align="center">
				<form method="post" action="<c:url value="/notice.do"/>">
					<input type="hidden" name="act" value="update">
					<div class="tableDiv">
						<table class="table table-bordered">
							<tr>
								<td>작성자</td>
								<td>${notice.name}</td>
							</tr>
							<tr>
								<td>제목</td>
								<td><input type="text" name="subject"
									placeholder="${notice.subject }" /></td>
							</tr>
							<tr>
								<td>내용</td>
								<td><textarea rows="5" name="content">${notice.content}</textarea>
								</td>
							</tr>
						</table>
					</div>
					<button class="btn btn-primary">수정</button>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>