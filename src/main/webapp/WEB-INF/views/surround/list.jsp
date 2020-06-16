
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
<link rel="stylesheet" type="text/css" 	href=<c:url value="/resources/css/surround/surround.css"/> />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div id="board">
		<div id="selectbox">
			<div id="cen">
			<select id="codename1" name="codename1" class="codename1">
				<option value="all">-대분류 선택-</option>
				<option value="음식">음식</option>
				<option value="생활서비스">생활서비스</option>
				<option value="소매">소매</option>
				<option value="의료">의료</option>
				<option value="학문/교육">학문/교육</option>
				<option value="관광/여가/오락">관광/여가/오락</option>
				<option value="부동산">부동산</option>
				<option value="숙박">숙박</option>
				<option value="스포츠">스포츠</option>
			</select> <select id="codename2" name="codename2" class="codename2">
				<option value="all">--중분류 선택--</option>
			</select> <select id="codename3" name="codename3" class="codename3">
				<option value="all">--소분류 선택--</option>
			</select>
		</div>
		</div>
		<hr>
		<h3>관심 지역 목록</h3>
		<hr>
			<div id="leftCenter" class="center">
				<div class="tableDiv">
					<table class="table table-bordered">
						<thead class="thead-light">
							<tr id="fixed_top">
								<th id="nom">번호</th>
								<th id="ci">동</th>
								<th id="gu">아파트이름</th>
								<th id="price">금액</th>
								<th>선택</th>
								<th>삭제</th>
							</tr>
						</thead>
						<thead id="listtable">
						</thead>
					</table>
				</div>
			</div>
		<div id="map" style="width: 45%; height: 500px;"></div>
	</div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c164a2d37e22a4db96b5694958a39cdf"></script>


	<!-- 지도선택 -->
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		mapOption = {
			center : new kakao.maps.LatLng(37.553305, 126.972675), // 지도의 중심좌표
			level : 4
		// 지도의 확대 레벨
		};
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		const path = "http://localhost:8000/ssafy";
		$("#listtable").ready(function() {
			$.ajax({
				type:"GET",
				url: path+"/surround/list2",
				success: function(data){
					Makelist(data);
				}
			});
		});
		function Makelist(data){
			$("#listtable").empty();
				data.forEach(function myFunction(item, index){
				$("#listtable").append(`
							<tr>
								<td id="no">\${item.no}</td>
								<td id="city">\${item.city}</td>
								<td id="gugun">\${item.gugun}</td>
								<td id="dong">\${item.dong}</td>
								<td><a href="#" onclick="selectlist(\${item.no})">선택</a></td>
								<td><a href="#" onclick="deletelist(\${item.no})">삭제</a></td>
							</tr>
				`);
				});
			}
		function deletelist(no){
			$.ajax({
				type:"GET",
				url: path+"/surround/deleteByNo",
				data : {
					"no":no
				},
				success: function(data){
					Makelist(data);
				}
			});
		}
		function selectlist(no){
			$.ajax({
				type:"GET",
				url: path+"/surround/selectByNo",
				data : {
					"no":no
				},
				success: function(data){
					setCenter(data);
				}
			});
		}
		function setCenter(data) {
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
	<!-- 분류선택 -->
	<script>
			$(document).ready(function() {
				$('#codename1').change(function() {
					var codename1 = this.value;
					$.ajax({
						type : "GET",
						url : path + "/surround/codename2/" + codename1,
						success : function(data) {
							makeCodename2(data);
						}
					})
				})
				$('#codename2').change(function() {
					var codename2 = this.value;
					$.ajax({
						type : "GET",
						url : path + "/surround/codename3/" + codename2,
						success : function(data) {
							makeCodename3(data);
						}
					})
				})
				$('#codename3').change(function() {
					var codename1 = $('#codename1 option:selected').val();
					var codename2 = $('#codename2 option:selected').val();
					var codename3 = this.value;
					$.ajax({
						type : "GET",
						data : {
							"codename1" : codename1,
							"codename2" : codename2,
							"codename3" : codename3
						},
						url : path + "/surround/drawmap",
						success : function(data) {
							makeMap(data);
						}
					})
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
		}
			function makeCodename2(data) {
			$("#codename2").empty();
			var base = $("<option id='all'>--중분류 선택--</option>")
			$("#codename2").append(base);

			data.forEach(function myFunction(item, index) {
				$("#codename2").append(
						"<option value='"+item.codename2+"'>" + item.codename2
								+ "</option>");
			});
			}
			function makeCodename3(data) {
				$("#codename3").empty();
				var base = $("<option id='all'>--소분류 선택--</option>")
				$("#codename3").append(base);

				data.forEach(function myFunction(item, index) {
					$("#codename3").append(
							"<option value='"+item.codename3+"'>" + item.codename3
									+ "</option>");
				});
				}
			
	</script>


</body>
</html>