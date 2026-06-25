<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Agregar Artista</title>
</head>
<body>
   <h1>Agregar un nuevo Artista</h1>
   
   <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
	<p>
		<form:label path="nombre">Nombre:</form:label>
		<form:input path="nombre"/>
		<form:errors path="nombre" style="color:red;"/>
	</p>
	<p>
		<form:label path="apellido">Apellido:</form:label>
		<form:input path="apellido"/>
		<form:errors path="apellido" style="color:red;"/>
	</p>
	<p>
		<form:label path="biografia">Biografía:</form:label><br>
		<form:textarea path="biografia" rows="5" cols="30"/>
		<form:errors path="biografia" style="color:red;"/>
	</p>
	<button type="submit">Guardar Artista</button>
   </form:form>
   
   <br>
   <a href="/artistas">Cancelar y volver</a>
</body>
</html>