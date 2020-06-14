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
	href="<c:url value="/resources/css/header.css"/>" />
</head>
<body>
	<script type="text/javascript">
		function movewrite() {
			location.href = "${root}/notice.do?act=writeForm";
		}
	</script>
	<div class="headerDiv" align="center">
		<a href="<c:url value="/"/>"><h1>Happy House</h1></a>
		<c:choose>
			<c:when test="${empty loginUser}">
				<br>
				<div id="header" align="right">
					<table>
						<tbody>
							<tr>
								<td>
									<form method="post"
										action="<c:url value="/user/registerform"/>">
										<button class="btn btn-primary">회원 가입</button>
									</form>
								</td>
								<td>
									<form method="post" action="<c:url value="/user/loginform"/>">
										<button class="btn btn-primary">로그인</button>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<strong>${loginUser.id }</strong>님 환영합니다.
			<div id="header" align="right">
					<table>
						<tbody>
							<tr>
								<td>
									<form method="post" action="<c:url value="/user/logout"/>">
										<button class="btn btn-primary">Logout</button>
									</form>
								</td>
								<td>
									<form method="post" action="<c:url value="/user/list"/>">
										<button class="btn btn-primary">회원정보</button>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="background">
			<h2 class="whiteString">HAPPY HOUSE에 오신것을 환영합니다</h2>
		</div>
		<div id="body">
			<nav>
				<ul class="nav nav-fill nav-pills justify-content-center">
					<li class="nav-item" id="locationSearch"><a class="nav-link"
						id="locationSearchtext" href="<c:url value="/"/>">
							지역검색 </a></li>
					<li class="nav-item" id="notice"><a class="nav-link"
						id="noticetext" href="<c:url value="/notice/noticelist"/>">
							공지사항 </a></li>
					<li class="nav-item" id="news"><a class="nav-link"
                  id="newstext" href="<c:url value="/news/newslist"/>"> 오늘의 뉴스 </a></li>
					<li class="nav-item" id="surround"><a class="nav-link"
						id="surroundtext" href="<c:url value="#"/>"> 주변탐방 </a></li>
					<c:if test="${loginUser.id != null}">
						<li class="nav-item" id="like"><a class="nav-link"
							id="liketext" href="<c:url value="#"/>"> 관심지역설정 </a></li>
						<li class="nav-item" id="likesurrond"><a class="nav-link"
							id="likesurrondtext" href="<c:url value="#"/>"> 관심지역둘러보기 </a></li>
						<li class="nav-item" id="qna"><a class="nav-link"
							id="qnatext" href="<c:url value="/house/qna"/>"> QnA게시판 </a></li>
						<li class="nav-item"id="aprt"><form method="post" action="<c:url value="/house/houselist"/>">
							<input type="hidden" name="pg" value="1" />
							<div class="page">
								<button id="butn" class="fun-btn">아파트검색</button>
							</div>
						</form></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<script type="text/javascript">
		$('#btn').on(
				'click',
				function(event) {
					$(this).toggleClass('start-fun');
					var $page = $('.page');
					$page.toggleClass('color-bg-start').toggleClass(
							'bg-animate-color');
					//change text when when button is clicked
					$(this).hasClass('start-fun') ? $(this)
							.text('stop the fun') : $(this).text(
							'start the fun');
				});
	</script>
</body>
</html>