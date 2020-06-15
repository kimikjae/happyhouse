<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<style>
.tablesize {
	width: 20%;
}

.background1 {
	margin-top: 30px;
	background-color: #BDBDBD;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div align="center">
		<form method="post" action="<c:url value="/interaction/register"/>">
			<h3>관심 지역</h3>
			<div class="background1">
				<div class="tablesize">
					<table class="table table-hover table-primary">
						<tr>
							<td>관심 지역 설정</td>
						<tr>
							<td><select id="city" name="city" class="city">
									<option value="all">도/광역시</option>
									<option value="서울특별시">서울시</option>
									<option value="경기도">경기도</option>
									<option value="인천광역시">인천광역시</option>
									<option value="부산광역시">부산광역시</option>
									<option value="대전광역시">대전광역시</option>
									<option value="대구광역시">대구광역시</option>
									<option value="울산광역시">울산광역시</option>
									<option value="세종특별자치시">세종시</option>
									<option value="광주광역시">광주광역시</option>
									<option value="강원도">강원도</option>
									<option value="충청북도">충청북도</option>
									<option value="경상북도">경상북도</option>
									<option value="경상남도">경상남도</option>
									<option value="전라북도">전라북도</option>
									<option value="전라남도">전라남도</option>
									<option value="제주특별자치도">제주도</option>
							</select></td>
						</tr>
						<tr>
							<td><select id="gugun" name="gugun" class="gugun">
									<option value="all">시/구/군</option>
							</select></td>
						</tr>
						<tr>
							<td><select id="dong" name="dong" class="dong">
									<option value="all">동</option>
							</select></td>
						</tr>
					</table>
				</div>
			</div>
			<button class="btn btn-primary">등록</button>
			<a class="btn btn-primary" href="<c:url value="/"/>" role="button">취소</a>
		</form>
	</div>
	<script>
		const path = "http://localhost:8000/ssafy";
		$(document).ready(function() {
			$('#city').change(function() {
				var city = this.value;
				$.ajax({
					type : "GET",
					url : path + "/ci/" + city,
					success : function(data) {
						makeGugun(data);
					}
				})
			})
			$('#gugun').change(function() {
				var city = $('#city option:selected').val();
				var gu = this.value;
				console.log(city);
				console.log(gu);
				$.ajax({
					type : "GET",
					data : {
						"city" : city,
						"gu" : gu
					},
					url : path + "/gugun",
					success : function(data) {
						makeDong(data);
					}
				})
			})
		})
		function makeGugun(data) {
			$("#gugun").empty();
			var base = $("<option id='all'>시/구/군</option>")
			$("#gugun").append(base);

			data.forEach(function myFunction(item, index) {
				$("#gugun").append(
						"<option value='"+item.name+"'>" + item.name
								+ "</option>");
			});
		}
		function makeDong(data) {
			$("#dong").empty();
			var base = $("<option id='all'>동</option>")
			$("#dong").append(base);

			data.forEach(function myFunction(item, index) {
				$("#dong").append(
						"<option value='"+item.dong+"'>" + item.dong
								+ "</option>");
			});
		}
	</script>
</body>
</html>