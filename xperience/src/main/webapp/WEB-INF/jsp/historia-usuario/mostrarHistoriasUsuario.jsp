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
	<form action="mover.do" >
	<h1>Historias usuario</h1>
	
		
		<c:forEach var="hu" items="${historiasUsuario}">
		 	<div> 
			<table>
				<tr>
				<div class="titulo">${hu.titulo}</div>	
				<div class="descripcion">${hu.descripcion}</div>
				<div class="orden">orden:  ${hu.orden}</div>
				<c:if test="hu.prioridad!=null">
					<div class="prioridad">${hu.prioridad}</div>
				</c:if>
				<tr>
				</table>		
		 	</div> 
	</c:forEach>
	
	
	Orden a Mover: <input type="text" id="ordenAntiguo" name="ordenAntiguo">
	Orden Nuevo: <input type="text" id="ordenNuevo" name="ordenNuevo">
	
	<input  value="mover" type="submit">

</body>
</form>
</html>