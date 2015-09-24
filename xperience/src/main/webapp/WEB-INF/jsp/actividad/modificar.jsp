<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modificar Actividad</title>
<style type="text/css">
#center {
margin: 0 auto;
margin: auto;
height: 500px;
width: 300px;
}

#titulo {
 width: 300px;
 margin: 0 auto;
}
</style>
	
</head>
<body>

<form:form method="POST"  action="/xperience/actividad/modificar.do" modelAttribute="actividadModificar" >
 
 <h2 id="titulo">Modificar Actividad </h2>
 <br/><br/>
   <table id="center">
     <tr>
        <td><a href="#">Historia Usuario</</a></td>
        <td></td>
    </tr>
   
    <tr>
        <td><form:label path="esfuerzo">Esfuerzo</form:label></td>
        <td><form:input path="esfuerzo" /></td>
    </tr>
    <tr>
        <td><form:label path="estatus">Usuario Asignado</form:label></td>
        <td><ul style="list-style-type: none;"><form:radiobuttons path="estatus" items="${estados}"  element="li"/></ul></td>
    </tr>
    
   <tr>
        <td><form:label path="usuarioId">Usuario Asignado</form:label></td>
        <td><form:select path="usuarioId" items="${listaUsuarios}" /></td>
    </tr>
   
    <tr>
        <td><form:label path="titulo">Titulo</form:label></td>
        <td><form:input path="titulo" /></td>
    </tr>
    
     <tr>
        <td><form:label path="descripcion">Descripcion</form:label></td>
        <td><form:textarea path="descripcion" /></td>
    </tr>
    

    <tr>
        <td colspan="2">
            
            <input id="inp" type="button" value="Cancelar" onclick="location.href='/xperience/historia-usuario.do'"/>
            <input type="submit" value="Modificar"/>
            
        </td>
    </tr>
</table>  

</form:form>


</body>
</html>