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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div id="board">
		<div id="selectbox">
			<select id="a" name="a" class="a">
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
			</select> <select id="b" name="b" class="b">
				<option value="all">시/구/군</option>
			</select> <select id="c" name="c" class="c">
				<option value="all">동</option>
			</select>
		</div>
		<hr>
		<h3>관심 지역 목록</h3>
		<hr>
		<div style="overflow: scroll; width: 25%; height: 500px; padding: 2px; float: left;">
			<div id="leftCenter" class="center">
				<div class="tableDiv">
					<table class="table table-bordered">
						<thead class="thead-light">
							<c:forEach var="list" items="${interlist}">
								<tr>
									<td id="city">${list.city}</td>
									<td id="gugun">${list.gugun}</td>
									<td id="dong">${list.dong}</td>
									<td><a href="#" onclick="movemap()">선택</a></td>
									<td><a href="<c:url value="/surround/delete?no=${list.no }"/>">삭제</a></td>
								</tr>
							</c:forEach>
						</thead>
						<thead id="listtable">
						</thead>
					</table>
				</div>
			</div>
		</div>
		<div id="map" style="width: 45%; height: 500px;"></div>
	</div>
		<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c164a2d37e22a4db96b5694958a39cdf"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		mapOption = {
			center : new kakao.maps.LatLng(37.553305, 126.972675), // 지도의 중심좌표
			level : 4
		// 지도의 확대 레벨
		};
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		const path = "http://localhost:8000/ssafy";
		
		function movemap(){
			var city= $('#city').text();
			var gugun=$('#gugun').text();
			var dong=$('#dong').text();
			console.log(city);
			console.log(gugun);
			console.log(dong);
			$.ajax({
				type : "GET",
				data : {
					"city" : city,
					"gu" : gugun,
					"dong" : dong
				},
				url : path + "/map2",
				success : function(data) {
					console.log(data);
				}
			})
		}
		
		
		
		
		
		
		function setCenter() {
			var moveLatLon = new kakao.maps.LatLng(data.lat, data.lng);
			map.setCenter(moveLatLon);
		}
	/* 	$("#map").ready(function() {
			$.ajax({
				type : "GET",
				url : path + "/map",
				success : function(data) {
					makeMap(data);
				}
			})

		})
		function makeMap(data) {
			// 마커 이미지의 이미지 주소입니다
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

			for (var i = 0; i < data.length; i++) {
				var loc = data[i].dong + " " + data[i].jibun;
				// 마커 이미지의 이미지 크기 입니다
				var imageSize = new kakao.maps.Size(20, 30);
				// 마커 이미지를 생성합니다    
				var markerImage = new kakao.maps.MarkerImage(imageSrc,
						imageSize);
				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
					map : map, // 마커를 표시할 지도
					position : new kakao.maps.LatLng(data[i].lat, data[i].lng), // 마커를 표시할 위치
					title : loc, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					image : markerImage
				});
			}
		} */
	</script>
</body>
</html>