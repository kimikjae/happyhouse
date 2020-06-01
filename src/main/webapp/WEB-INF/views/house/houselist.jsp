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
	function search() {
		if ($('input:checkbox[name="type1"]').is(":checked") == true
				|| $('input:checkbox[name="type2"]').is(":checked") == true
				|| $('input:checkbox[name="type3"]').is(":checked") == true
				|| $('input:checkbox[name="type4"]').is(":checked") == true) {

			document.getElementById("searchform").action = "<c:url value="/house/searchlist"/>";
			document.getElementById("searchform").submit();
		} else
			alert("검색 타입을 선택 하셔야합니다.");
	}
	function pageMove(pg) {
		document.getElementById("pg").value = pg;
		document.getElementById("pageform").action = "<c:url value="/house/houselist"/>";
		document.getElementById("pageform").submit();
	}
</script>
<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/house/houselist.css"/> />
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="pg" id="pg" value="">
	</form>
	<h1 id="mainWindow" align="center">전체 검색 화면</h1>
	<form id="searchform" method="post"
		action="<c:url value="/house/searchlist"/>">
		<input type="hidden" name="pg" value="1" />
		<div align="left">
			<label> <input type="checkbox" name="type1" value="1">
				아파트 매매
			</label> <label><input type="checkbox" name="type2" value="2">
				연립 다세대 매매</label> <label><input type="checkbox" name="type3"
				value="3"> 아파트 전월세</label> <label><input type="checkbox"
				name="type4" value="4"> 연립 다세대 전월세</label>
		</div>
		<div align="right">
			<select name="searchType" id="searchType" name="searchType">
				<option value="all">동/아파트</option>
				<option value="dong">동</option>
				<option value="AptName">아파트</option>
			</select> <input type="text" name="searchWord" id="searchWord" />
			<button class="btn btn-secondary" type="button"
				onclick="javascript:search();">검색</button>
		</div>
	</form>
	<div class="tableDiv" style="float: left;">
		<table class="table table-bordered">
			<thead class="thead-light">
				<tr>
					<th>번호</th>
					<th>동</th>
					<th>아파트이름</th>
					<th>거래금액</th>
					<th>거래종류</th>
				</tr>
			</thead>
			<c:if test="${List eq 'Empty'}">
				<tr>
				</tr>
			</c:if>
			<c:if test="${List ne 'Empty'}">
				<c:forEach var="house" items="${List}">
					<tr>
						<td>${house.no}</td>
						<td>${house.dong}</td>
						<td><a
							href="<c:url value="/house/housedetail?no=${house.no}"/>">${house.aptName}</a>
						</td>
						<td>${house.dealAmount}</td>
						<c:if test="${house.type eq '1'}">
							<td>아파트 매매</td>
						</c:if>
						<c:if test="${house.type eq '2'}">
							<td>연립 다세대 매매</td>
						</c:if>
						<c:if test="${house.type eq '3'}">
							<td>아파트 전월세</td>
						</c:if>
						<c:if test="${house.type eq '4'}">
							<td>연립 다세대 전월세</td>
						</c:if>
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

	<div class="tableDiv" style="float: right;">
		<c:if test="${AoptionD eq 'dong'}">
			<img src="./img/아남1.jpg">
			<h1>${dongimg}</h1>
		</c:if>
		<c:if test="${AoptionD eq 'AptName'}">
			<img src="./img/현대뜨레비앙.jpg">
			<h1>${Aptimg}</h1>
		</c:if>
	</div>

</body>
</html>