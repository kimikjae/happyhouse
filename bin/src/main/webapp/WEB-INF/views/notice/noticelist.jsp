<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function movewrite() {
		location.href = "${root}/notice.do?act=writeForm";
	}
	function searchArticle() {
		if (document.getElementById("word").value == "") {
			alert("모든 목록 조회!!");
		}
		document.getElementById("searchform").action = "${root}/notice.do";
		document.getElementById("searchform").submit();
	}
</script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href=<c:url value="/notice/noticelist.css"/> />
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div>
		<h2 align="center">공지사항</h2>
		<div class="tableDiv">
			<c:choose>
				<c:when test="${notices.size() != 0}">
					<table class="table table-bordered">
						<thead class="thead-light">
							<tr>
								<th>게시번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>게시일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="notice" items="${notices}">
								<tr>
									<td>${notice.noticeno}</td>
									<td><a
										href="<c:url value="/notice.do?act=detail&noticeno=${notice.noticeno}"/>">${notice.subject}</a>
									</td>
									<td>${notice.name}</td>
									<td>${notice.uploaddate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<table class="table table-active">
						<tbody>
							<tr class="table-info" align="center">
								<td>작성된 글이 없습니다.</td>
							</tr>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="div-float">
			<table class="table table-borderless">
				<tr>
					<td>
						<form id="searchform" method="get" class="form-inline" action="">
							<input type="hidden" name="act" id="act" value="list"> <select
								class="form-control margin-right" name="key" id="key">
								<option value="id" selected="selected">아이디</option>
								<option value="name">작성자이름</option>
								<option value="subject">제목</option>
							</select> <input type="text" class="form-control margin-right"
								placeholder="검색하세요" name="word" id="word">
							<button type="button" class="btn btn-primary margin-right"
								onclick="javascript:searchArticle();">검색</button>

						</form>
					</td>
					<td align=right>
						<form method="post" action="<c:url value="/notice.do"/>">
							<input type="hidden" name="act" value="writeForm">
							<button class="btn btn-primary">글쓰기</button>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>