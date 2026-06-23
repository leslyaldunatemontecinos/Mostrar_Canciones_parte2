<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
<!DOCTYPE html>
<html>
<head>
      <meta charset="UTF-8">
      <title>Editar Canción</title>
   </head>
   </html>
	
      <h1>Editar Canción</h1>
	  
	  <form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">

	  <div>
		<form:label path="titulo">Titulo:</form:label>
		<form:input path="titulo" />
		<form:errors path="titulo" cssStyle="color:red;" />
	  </div>
	  
	  <div>
	  	<form:label path="artista">Artista:</form:label>
	  	<form:input path="artista" />
	  	<form:errors path="artista" cssStyle="color:red;" />
	    </div>
		
	<div>
		<form:label path="album">Album:</form:label>
		<form:input path="album" />
		<form:errors path="album" cssStyle="color:red;" />
	</div>  
	
	<div>
		<form:label path="genero">Género:</form:label>
		<form:input path="genero" />
		<form:errors path="genero" cssStyle="color:red;" />
	</div>  
	
	<div>
		<form:label path="idioma">Idioma:</form:label>
		<form:input path="idioma" />
		<form:errors path="idioma" cssStyle="color:red;" />
	</div> 
	
		<br>
		<button type="submit">Guardar Cambios</button>
	</form:form>
	
	<br><br>
	<a href="/canciones">Volver a la lista de canciones</a>

</body>
</html>		  