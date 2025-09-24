<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<% 
	//pageContext.setAttribute("name", "page yang");
	request.setAttribute("name", "request yang");
	session.setAttribute("name", "session yang");
	application.setAttribute("name", "application yang");
	%>
	
	<%= pageContext.getAttribute("name") %><br> <!-- 위보다 아래가 더 쓰기 편함. -->
	
	${pageScope.name }<br>
	${requestScope.name }<br>
	${sessionScope.name }<br>
	${applicationScope.name }<br>
	
	${cookie.JSESSIONID.value }<br>  <!-- value 떼면 tostring 한게나옴.  -->
	
	<h3>나는 누구일까?</h3>
	${name} <!-- page context 하나씩 제거하면 가까이있는거부터 찾아간단거 알수있음.  -->
	
</body>
</html>