<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detalle Sprint</title>
</head>
<body>
	<h1>Detalle Sprint</h1>

		<div class="esfuerzo">${sprintDetail.nombre}</div>
		<div class="titulo">${sprintDetail.esfuerzoTotal}</div>	
		<div class="prioridad">${sprintDetail.fechaFin}</div>	
		<div class="esfuerzo">${sprintDetail.fechaIni}</div>





		<c:forEach var="hu" items="${sprintDetail.historiaUsuarios}">
			<div>
				<div class="titulo">${hu.titulo}</div>	
				<div class="prioridad">${hu.prioridad}</div>	
				<div class="esfuerzo">${hu.esfuerzo}</div>
			</div>
		</c:forEach>

	<button id="botonAnadir" > </button>
</body>
</html>
