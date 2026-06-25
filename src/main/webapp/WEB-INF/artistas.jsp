<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Lista de Artistas</title>
</head>
<body>
   <h1>Lista de Artistas</h1>
   <ul>
	<c:forEach items="${listaArtistas}" var="artista">
		<li>
			<a href="/artistas/detalle/${artista.id}">
				<c:out value="${artista.nombre}"/> <c:out value="${artista.apellido}"/>
			</a>
		</li>
	</c:forEach>
   </ul>
   <br><br>
   <a href="/canciones">Ir a canciones</a>
   <span> | </span> 
   <a href="/artistas/formulario/agregar">Agregar un nuevo Artista</a>

</body>
</html>