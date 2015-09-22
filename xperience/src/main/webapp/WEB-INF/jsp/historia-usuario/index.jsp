<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Historias de usuario</title>
</head>
<body>
	<h1>Historias usuario</h1>
	
	<c:forEach var="hu" items="${historiasUsuario}">
		<div>
			<div class="titulo">${hu.titulo}</div>	
			<div class="desacripcion">${hu.descripcion}</div>	
		</div>
	</c:forEach>
</body>
</html>