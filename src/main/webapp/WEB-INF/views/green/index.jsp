<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/green/index.css"/> />
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>

	<div id="leftCenter" class="center">
	<h1 id="mainWindow" align="center">관심지역 목록</h1>
		<div class="tableDiv">
			<table class="table table-bordered">
				<thead class="thead-light">
					<tr>
						<th>동/면</th>
						<th>구/군</th>
						<th>보기</th>
						<th>삭제</th>
					</tr>
				</thead>
				<c:if test="${List eq 'Empty'}">
					<tr>
					</tr>
				</c:if>
				<c:if test="${List ne 'Empty'}">
					<c:forEach var="address" items="${List}">
						<tr>
							<td>${address.dong}</td>
							<td>${address.gugun}</td>
							<td>
								<a href="javascript:selectDong('${address.dong}')">보기</a>
							</td>
							<td>
								<a href="<c:url value="/green/delete?num=${address.num}"/>">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
	<div class="center">
		<div class="tableDiv">
			<div id="map" style="width: 100%; height: 100%; min-height: 500px;"></div>
		</div>
	</div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8a74d23e79598649f4ce44d5980a97ed&libraries=services,drawing"></script>
	<script>
	</script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(33.450701, 126.570667),
			level : 3
		};

		var map = new kakao.maps.Map(container, options);

		let points = new Array();
		let prevMarker = new Array();
		let prevInfoWindow = new Array();
		function selectDong(dong){
			for(marker of prevMarker) {
				marker.setMap(null);
			}
			for(infoWindow of prevInfoWindow) {
				infoWindow.close();
			}
			prevMarker = new Array();
			prevInfoWindow = new Array();
			let restAddress='http://localhost:8000/ssafy/api/map/dongtogreen/'+dong;
			axios.get(restAddress)
			.then(response => {
				for(let i=0; i<response.data.length;++i) {
					let v = response.data[i];
					var coords = new kakao.maps.LatLng(v.lat,v.lng);
			        points.push(coords);
			        
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });
			        
			        var infowindow = new kakao.maps.InfoWindow({
			            content: `
			            <div style="width:300px;text-align:center;padding:6px 0;">
			            	녹지명 : \${v.name}
			            </div>
			            `
			        });
			        infowindow.open(map, marker);
			        prevMarker.push(marker);
			        prevInfoWindow.push(infowindow);
				}
				if(response.data.length > 0){
					var bounds = new kakao.maps.LatLngBounds();
					for (let i = 0; i < points.length; i++) {
					    // LatLngBounds 객체에 좌표를 추가합니다
					    bounds.extend(points[i]);
					    //console.log('진입');
					}
					map.setBounds(bounds);
				}
			})
		}
	</script>
</body>
</html>