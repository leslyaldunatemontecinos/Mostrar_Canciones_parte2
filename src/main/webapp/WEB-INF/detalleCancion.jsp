<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
      <meta charset="UTF-8">
      <title>Detalle de la Canción</title>
   </head>
   <body>
	
      <h1>Detalle de la Canción</h1>
	  
	<ul>
		<li><strong>ID:</strong> ${cancion.id}</li>
		<li><strong>Titulo:</strong> ${cancion.titulo}</li>	
		<li><strong>Artista:</strong> ${cancion.artista}</li>	
		<li><strong>Album:</strong> ${cancion.album}</li>	
		<li><strong>Genero:</strong> ${cancion.genero}</li>
		<li><strong>Idioma:</strong> ${cancion.idioma}</li>
		<li><strong>Fecha de Creacion:</strong> ${cancion.createdAt}</li>
		<li><strong>Ultima Actualizacion:</strong> ${cancion.updatedAt}</li>
	</ul>
	
	<br>
	<a href="/canciones">Volver a lista de canciones</a>
	</body>
	</html>