<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function pageMove(pg) {
		document.getElementById("pg").value = pg;
		document.getElementById("pageform").action = "<c:url value="/house/houselist"/>";
		document.getElementById("pageform").submit();
	}
</script>
<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/house/houselist.css"/> />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
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
					<li class="nav-item" id="notice"><a class="nav-link"
						id="noticetext" href="<c:url value="/notice/noticelist"/>">
							공지사항 </a></li>
					<li class="nav-item" id="news"><a class="nav-link"
						id="newstext" href="<c:url value="#"/>"> 오늘의 뉴스 </a></li>
					<li class="nav-item" id="surround"><a class="nav-link"
						id="surroundtext" href="<c:url value="#"/>"> 주변탐방 </a></li>
					<c:if test="${loginUser.id != null}">
						<li class="nav-item" id="like"><a class="nav-link"
							id="liketext" href="<c:url value="#"/>"> 관심지역설정 </a></li>
						<li class="nav-item" id="likesurrond"><a class="nav-link"
							id="likesurrondtext" href="<c:url value="#"/>"> 관심지역둘러보기 </a></li>
						<li class="nav-item" id="qna"><a class="nav-link"
							id="qnatext" href="<c:url value="/house/qna"/>"> QnA게시판 </a></li>
						<li class="nav-item" id="apart"><form method="post"
								action="<c:url value="/house/houselist"/>">
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


	<h1 id="mainWindow" align="center">전체 검색 화면</h1>
	<form id="searchform" method="post"
		action="<c:url value="/house/searchlist"/>">
		<div align="right">
			<input type="text" name="searchWord" id="searchWord"
				placeholder="원하는 아파트를 입력해주세요." />
			<button class="btn btn-secondary">검색</button>
		</div>
	</form>
	<div id="center">
		<div class="tableDiv">
			<table class="table table-bordered">
				<thead class="thead-light">
					<tr>
						<th>번호</th>
						<th>동</th>
						<th>아파트이름</th>
						<th>지번</th>
						<th>금액</th>
					</tr>
				</thead>
				<c:if test="${List eq 'Empty'}">
					<tr>
					</tr>
				</c:if>
				<c:if test="${List ne 'Empty'}">
					<c:forEach var="house" items="${List}">
						<tr>
							<td id="no">${house.no}</td>
							<td id="dong">${house.dong}</td>
							<td id="aptname"><a
								href="<c:url value="/house/housedetail?no=${house.no}"/>">${house.aptName}</a>
							</td>
							<td id="jibun">${house.jibun }</td>
							<td>${house.dealAmount }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<div align="center">
				<table>
					<tr>
						<th>${navigation.navigator }</th>
					<tr>
				</table>
			</div>
			<form method="post" action="<c:url value="/"/>">
				<div align="center">
					<button class="btn btn-secondary">메인으로 돌아가기</button>
				</div>
			</form>
		</div>
	</div>
	<!-- 	<div id="map" style="width: 1000px; height: 600px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c164a2d37e22a4db96b5694958a39cdf"></script>
	<script>
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		
		};
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		var str1 = $('#dong').innerText;
		console.log(str1);
		alert(str1);
	</script> -->
</body>
</html>