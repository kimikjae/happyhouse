<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 리스트</title>
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
  	<link rel="stylesheet" type="text/css" href=<c:url value="/resources/css/news/newslist.css"/> />
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div>
		<h2 align="center">오늘의 뉴스</h2>
		<div class="tableDiv">
			<c:choose>
				<c:when test="${notices.size() != 0}">
					<table class="table table-bordered">
						<thead class="thead-light">
							<tr>
								<th>게시번호</th>
								<th>제목</th>
								<th>신문사</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="news" items="${list}">
								<tr>
									<td>${news.no}</td>
									<td><a href=${news.summary}>${news.headLine}</a></td>
									<td>${news.pressName}</td>
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
	</div>
</body>
</html>




