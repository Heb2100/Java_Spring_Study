<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 반복</title>
</head>
<body>
	<%
		String[] dramaList = {"대장굼", "추노", "도깨비"};
		pageContext.setAttribute("dramaList", dramaList);
	%>
	
	<ol>
		<c:forEach var="drama" items = "${dramaList}">
			<li>${drama}</li>
		</c:forEach>
	</ol>
	
	<!--  index 로 번호붙이기  -->
	<c:forEach var="drama" items = "${dramaList}" varStatus="status">
		${status.index+1} : ${drama} : ${status.count }<br>
	</c:forEach>
	
	
</body>
</html>