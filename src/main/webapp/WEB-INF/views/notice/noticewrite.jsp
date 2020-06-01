<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>글작성</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href=<c:url value="/notice/noticewrite.css"/> />
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<c:choose>
		<c:when test="${empty loginUser}">
			<div>
				<h2>회원만 글 작성이 가능합니다</h2>
				<a href="<c:url value="/user.do"/>">Home</a> <a
					href="<c:url value="/notice.do?act=noticelist"/>">Back</a>
			</div>
		</c:when>
		<c:otherwise>
			<h2 align="center">공지사항 작성</h2>
			<div class="container" align="center">
				<form method="post" action="<c:url value="/notice.do"/>">
					<input type="hidden" name="act" value="write">
					<div class="tableDiv">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td><label for="subject">제목:</label></td>
								<td><input type="text" id="subject" name="subject"></td>
							</tr>
							<tr>
								<td><label for="content">내용:</label></td>
								<td><textarea rows="15" id="content" name="content"></textarea></td>
							</tr>
						</tbody>
					</table>
					</div>
					<div>
						<button>글작성</button>
						<button type="reset">초기화</button>
					</div>
				</form>
			</div>
		</c:otherwise>
	</c:choose>


</body>
</html>