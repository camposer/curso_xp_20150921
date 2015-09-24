<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listar Actividades</title>
</head>
<body>
	<h1>Listar Actividades</h1>
	
	
	
	<table>
	<tr>
		<td>HISTORIA de USUARIO</td>
		<td>Actividad no iniciada</td>
		<td>Actividad iniciada</td>
		<td>Actividad finalizada</td>
	</tr>
		
    <c:forEach items="${values}" var="row">
        <tr>
       		
	            <c:forEach items="${row}" var="value">
	                <td>${value}</td>
	            </c:forEach>
        </tr>
    </c:forEach>
	</table>
</body>
</html>