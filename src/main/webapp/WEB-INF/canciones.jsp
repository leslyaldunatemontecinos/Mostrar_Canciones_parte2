<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Lista de Canciones</title>
</head>
<body>
   <h1>Lista de canciones</h1>
   <table border="1" cellpadding="5" cellspacing="0">
	<thead>
		<tr>
			<th>Título</th>
			<th>Autor</th>
			<th>Detalle</th>
		</tr>
	</thead>
	</body>
		<c:forEach var="cancion" items="${listaCanciones}">
			<tr>
				<td><c:out value="${cancion.titulo}"/></td>
				<td><c:out value="${cancion.artista.nombre}"/></td>
				<td>
					<a href="/canciones/detalle/${cancion.id}">Detalle</a>
				</td>
			</tr>
		</c:forEach>
	</body>
</table>
		<%-- Parte 2 --%>
	<br>
		<a href="/canciones/formulario/agregar">
			<button> Agregar una Canción</button>
		</a>
		<%-- Parte 5 --%>
	<br><br>
	<a href="/artistas">Ir a artistas</a>	
	</body>
   </html>