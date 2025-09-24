<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<!--  파라미터를 꺼내서 보자. id 라는 파라미터가 놀어와따 -->
	<%= request.getParameter("id") %> <br><!-- 얘는 id 가 없을때 null이 나온다.  -->
	<%= request.getParameter("id") == "ssafy" %><br>
	<%= request.getParameter("id").equals("ssafy") %><br>
	
	<!--  EL  -->
	${param.id}<br> <!-- 얘는 id 가 없을때 아무것도 안나온다.  -->
	${param.id == "ssafy"}<br> <!-- el 표현식의 경우엔 == 을 쓰더라도 내부적으로 equals 를 쓴다.  -->
	${param.id eq "ssafy"}<br>
</body>
</html>