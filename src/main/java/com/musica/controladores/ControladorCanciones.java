package com.musica.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.musica.modelos.Artista;
import com.musica.modelos.Cancion;
import com.musica.servicios.ServicioArtistas;
import com.musica.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

	@Autowired
	private ServicioCanciones servicioCanciones;
	
	// Agrego PARTE 5
	@Autowired 
	private ServicioArtistas servArtistas;

	// Ruta para ver todas las canciones
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
		model.addAttribute("listaCanciones", canciones);
		return "canciones";
	}

	// Ruta para ver el detalle de una cancion
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
		Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);

		if (cancion == null) {
			return "redirect:/canciones";
		}

		model.addAttribute("cancion", cancion);
		return "detalleCancion";
	}
	// PARTE 2 Mostrar formulario para agregar / PARTE 5 Modifico el GetMapping para mandar la lista de artistas al select
	@GetMapping("/canciones/formulario/agregar/{id}")
	public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model model) {
			model.addAttribute("listaArtistas",servArtistas.obtenerTodosLosArtistas());
			return "agregarCancion";
		}
	// PARTE 5 Modifico procesar el formulario de agregar
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result, Model model) {
	
		if (result.hasErrors()) {
			model.addAttribute("listaArtistas",servArtistas.obtenerTodosLosArtistas());
			return "agregarCancion";
		}
		// Vinculamos el Artista completo antes de guardar
		if (cancion.getArtista() !=null && cancion.getArtista().getId() !=null) {
			Artista artistaAsociado = servArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
			cancion.setArtista(artistaAsociado);
		}else {
			//Si no se selecciono ningun artista valido, recargamos el formulario con una alerta
			model.addAttribute("listaArtistas", servArtistas.obtenerTodosLosArtistas());
			result.rejectValue("artista", "error.artista", "Debes seleccionar un artista valido de la lista");
			return "agregarCancion";		
	
		}
		
		servicioCanciones.agregarCancion(cancion);
		return "redirect:/canciones";
		}
	
	//PARTE 3 Actualizar cancion
	// 1. Formulario para editar:Carga la cancion existente para su ID y la envia a la vista
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
		// buscamos la cancion usando el metodo que tenemos implementado
		Cancion cancionExistente = servicioCanciones.obtenerCancionPorId(idCancion);
		if (cancionExistente == null) {
			return "redirect:/canciones";
		}
		//PARTE 5 Cargamos los artistas para llenar el select formulario
		model.addAttribute ("listaArtistas", servArtistas.obtenerTodosLosArtistas());
		model.addAttribute("cancion", cancionExistente);
		return "editarCancion";
		}
		
	//2. Procesar la edicion: Recibe el objeto con las modificaciones y valida los datos
	@PostMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(
			@Valid @ModelAttribute("cancion") Cancion cancion,
			BindingResult result,
			@PathVariable("idCancion") Long idCancion, Model model) {
		
		if(result.hasErrors()) {
			//Si falta alguna validacion,regresa al formulario manteniendo los errores en pantalla
			model.addAttribute("listaArtistas", servArtistas.obtenerTodosLosArtistas());
			return "editarCancion";
		}
		
	//PARTE 5. Buscamos el objeto Artista completo 
	if (cancion.getArtista() != null && cancion.getArtista().getId() != null) {
		Artista artistaReal = servArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
		cancion.setArtista(artistaReal);
	}
	
	//Mantenemos el ID de la ruta en el objeto 
	cancion.setId(idCancion);
	//Invocamos al metodo de servicio
	servicioCanciones.actualizaCancion(cancion);
	return"redirect:/canciones";	
}
	//PARTE 4 Eliminar cancion
	@GetMapping("/canciones/eliminar/{idCancion}")
	public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
	servicioCanciones.eliminaCancion(idCancion);
	return "redirect:/canciones";
	}
}


