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
	// PARTE 2
	@GetMapping("/canciones/formulario/agregar/{idCancion}")
	public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
					return "agregarCancion";
		}
	// Procesar el formulario (Correcion de ortografia en result y cierres)
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
	}

