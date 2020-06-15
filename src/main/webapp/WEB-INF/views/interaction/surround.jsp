<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
		<div id="board">
		<div id="selectbox">
			<select id="city" name="city" class="city">
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
			</select> <select id="gugun" name="gugun" class="gugun">
				<option value="all">시/구/군</option>
			</select> <select id="dong" name="dong" class="dong">
				<option value="all">동</option>
			</select>
		</div>

		<div id="map" style="width: 45%; height: 500px;"></div>
		<div style="overflow:scroll; width:55%; height:500px; padding:2px;">
		<div id="leftCenter" class="center">
			<div class="tableDiv">
				<table class="table table-bordered">
					<thead class="thead-light">
						<tr>
							<th id="dongd">동</th>
							<th id="aptname">아파트이름</th>
							<th id="price">금액</th>
							<th id="area">면적</th>
							<th id="jebun">지번</th>
						</tr>
					</thead>
					<thead id="listtable">
					</thead>
				</table>
			</div>
		</div>
		</div>
	</div>
</body>
</html>