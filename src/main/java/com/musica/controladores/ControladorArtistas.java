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
import com.musica.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
	
	@Autowired
	private ServicioArtistas servArtistas;
	
	//Mostrar todos los artistas
	@GetMapping("/artistas")
	public String desplegarArtistas(Model model) {
		List<Artista> artistas= servArtistas.obtenerTodosLosArtistas();
		model.addAttribute("listaArtistas", artistas);
		return "artistas";
		}
	// Detalle del artista
	@GetMapping("/artistas/detalle/{idArtista}")
	public String desplegarDetalleArtistas(@PathVariable ("idArtista")Long idArtista, Model model) {
		Artista artista= servArtistas.obtenerArtistaPorId(idArtista);
		model.addAttribute("artista", artista);
		return "detalleArtista";
}
	// Formulario para agregar artista
	@GetMapping("/artistas/formulario/agregar")
	public String formularioAgregarArtistas(Model model) {
		//Eliminamos el @PathVariable porque no se necesita un ID para crear un artista nuevo
		//Pasamos un objeto Artista vacio al modelo para que formulario JSP pueda mapearlo
		model.addAttribute("artista", new Artista());
		return "agregarArtista";
	}
	
	// Procesar el formulario
	@PostMapping("/artistas/procesa/agregar")
	public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult result) {
		if (result.hasErrors()) {
			return "agregarArtista";
		}
	servArtistas.agregarArtista(artista);
	return "redirect:/artistas";
	}
}
	
