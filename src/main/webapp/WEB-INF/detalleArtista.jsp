<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Detalle del Artista</title>
</head>
<body>
   <h1>Detalle del Artista</h1>
   <p><strong>ID:</strong> ${artista.id}</p>
   <p><strong>Nombre completo:</strong> ${artista.nombre} ${artista.apellido}</p>
   <p><strong>Biografía:</strong> ${artista.biografia}</p>
	
	<h3>Canciones de este artista:</h3>
	<ul>
		<c:forEach items="${artista.canciones}" var="cancion">
			<li><c:out value="${cancion.titulo}"/>
				<c:out value="${cancion.album}"/></li>	
		</c:forEach>
		<c:if test="${empty artista.canciones}">
			<li>Este artista aún no tiene canciones registradas.</li>
		</c:if>
	</ul>
	<br><br>
	<a href="/artistas">Volver a la lista de artistas</a>
</body>
</html>