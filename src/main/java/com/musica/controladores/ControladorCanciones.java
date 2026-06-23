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

import com.musica.modelos.Cancion;
import com.musica.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

	@Autowired
	private ServicioCanciones servicioCanciones;

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
	// PARTE 2 Mostrar formulario para agregar
	@GetMapping("/canciones/formulario/agregar/{idCancion}")
	public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
					return "agregarCancion";
		}
	// Procesar el formulario 
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result) {
		
		//Si tiene errores de caracteres, regresa al formulario
		if (result.hasErrors()) {
			return "agregarCancion";
		}
		
		// Si esta limpio, guarda
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
		
		// Pasamos la cancion al modelo para que el formulario JSP se precargue automaticamente
		model.addAttribute("cancion", cancionExistente);
		return "editarCancion";
		}
	
	//2. Procesar la edicion: Recibe el objeto con las modificaciones y valida los datos
	@PostMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(
			@Valid @ModelAttribute("cancion") Cancion cancion,
			BindingResult result,
			@PathVariable("idCancion") Long idCancion) {
		
		if(result.hasErrors()) {
			//Si falta alguna validacion,regresa al formulario manteniendo los errores en pantalla
			return "editarCancion";
			}
			//Mantenemos el ID de la ruta en el objeto para que JPA ejecute un UPDATE 
			cancion.setId(idCancion);
			
			//Invocamos el metodo de servicio
			servicioCanciones.actualizaCancion(cancion);
			
			return "redirect:/canciones";
		}
	
	//PARTE 4 Eliminar cancion
	@GetMapping("/canciones/eliminar/{idCancion}")
	public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
	servicioCanciones.eliminaCancion(idCancion);
	return "redirect:/canciones";
	}
}


