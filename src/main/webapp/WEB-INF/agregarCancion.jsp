<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Agregar Canción</title>
   <style>
	/*Estilo par que los errores de validacion resalten en color rojo*/
   	.error-mensaje{
		color:red;
		font-size: 0.9em;
		font-weight: bold;
		display:block;
		margin-top: 5px;
	}
	.campo-formulario{
		margin-bottom: 15px;
	}
	</style>
</head>
<body>
   <h1>Agregar una Nueva Canción</h1>
   <hr>
  	<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
		
	<div class="campo-formulario">
		<form:label path="titulo">Titulo:</form:label>
		<form:input path="titulo"/>
				
		<%-- MUESTRA EL ERROR SI TIENE MENOS DE 5 CARACTERES --%>
		<form:errors path="titulo" cssClass="error-mensaje" />
	</div>
	
	<div class="campo-formulario">
			<form:label path="artista">Artista:</form:label>
			<form:input path="artista"/>
			<form:errors path="artista" cssClass="error-mensaje" />
		</div>
		
	<div class="campo-formulario">
			<form:label path="album">Album:</form:label>
			<form:input path="album"/>
			<form:errors path="album" cssClass="error-mensaje" />
		</div>	
		
	<div class="campo-formulario">
			<form:label path="genero">Género:</form:label>
			<form:input path="genero"/>
			<form:errors path="genero" cssClass="error-mensaje" />
		</div>
		
	<div class="campo-formulario">
			<form:label path="idioma">Idioma:</form:label>
			<form:input path="idioma"/>
			<form:errors path="idioma" cssClass="error-mensaje" />
		</div>
		
		<button type="submit">Guardar Canción</button>
	
	</form:form>
	<br>
	<hr>
	<%-- Enlace para regresar a la lista principal--%>
	<a href="/canciones">Volver a la lista de canciones</a>
	
</body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                                                            