<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 리스트</title>
  <link rel="stylesheet" type="text/css"  />
  <!-- href=<c:url value="/resources/css/news/newslist.css"/> -->
</head>
<body>
<div id = "container">
  <h3>News 목록</h3>
  <hr>
  <form>
    <table border="1">
      <tr>
         <th>뉴스번호</th>
         <th>헤드라인</th>
         <th>신문사</th>
      </tr>
    <c:forEach items="${list}" var="news">      
      <tr>
         <td>${news.no}</td>
         <td><a href=${news.summary}>${news.headLine}</a></td>
         <td>${news.pressName}</td>
      </tr>
     </c:forEach>
    </table>
  </form>
</div>     
</body>
</html>




