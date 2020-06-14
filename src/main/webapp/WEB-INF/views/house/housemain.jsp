<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/locationSearch.css"/> />
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

		<div id="map" style="width: 50%; height: 500px;"></div>
	</div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c164a2d37e22a4db96b5694958a39cdf"></script>
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
	<script>
		$("#map").ready(function() {
			$.ajax({
				type : "GET",
				url : path + "/map",
				success : function(data) {
					makeMap(data);
				}
			})

		})
		function makeMap(data) {
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
			mapOption = {
				center : new kakao.maps.LatLng(37.553305, 126.972675), // 지도의 중심좌표
				level : 4
			// 지도의 확대 레벨
			};

			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
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
		}
	</script>
</body>
</html>