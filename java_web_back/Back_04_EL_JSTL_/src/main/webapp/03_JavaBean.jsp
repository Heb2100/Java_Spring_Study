<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.dto.Person" %>

<%
	Person p = new Person("SSAFY", 20, "M", new String[] {"수면", "식사"});

	pageContext.setAttribute("p", p);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean</title>
</head>
<body>
	<h2>JavaBeans</h2> <!--  toString 과 동일하게 나온다.  -->
	<div>전체 정보 : ${p}</div>
	<div>이름 : ${p.namee}</div>
	<div>나이 : ${p["age"]}</div>
	<div>취미 : ${p["hobbies"][0]}</div>
</body>
</html>
