<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$('#btn').on('click', function(event) {
		$(this).toggleClass('start-fun');
		var $page = $('.page');
		$page.toggleClass('color-bg-start').toggleClass('bg-animate-color');
		//change text when when button is clicked
		$(this).hasClass('start-fun')
			? $(this).text('stop the fun')
			: $(this).text('start the fun');
	});
</script>
<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/house/housemain.css"/> />
</head>
<body>
	<form method="post" action="<c:url value="/house/houselist"/>">
		<input type="hidden" name="pg" value="1" />
		<div class="page">

			<button class="fun-btn">아파트 검색</button>

		</div>
	</form>
</body>
</html>