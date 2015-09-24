<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sprint</title>
</head>
<body>
	<h1>Sprint</h1>
	
	<c:forEach var="s" items="${sprint}">
		<div>
			<div class="titulo">${s.nombre}</div>	
			<div class="fechaini">${s.fechaIni}</div>	
			<div class="fechaini">${s.fechaFin}</div>	
		</div>
	</c:forEach>
</body>
</html>