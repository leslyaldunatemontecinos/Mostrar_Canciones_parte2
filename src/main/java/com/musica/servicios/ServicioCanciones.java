package com.musica.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musica.modelos.Cancion;
import com.musica.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {

	@Autowired
	private RepositorioCanciones repositorioCanciones;

	// Obtener todas las canciones
	public List<Cancion> obtenerTodasLasCanciones() {
		return repositorioCanciones.findAll();
	}

	// Obtener cancion por ID
	public Cancion obtenerCancionPorId(Long id) {
		Optional<Cancion> optionalCancion = repositorioCanciones.findById(id);
		if (optionalCancion.isPresent()) {
			return optionalCancion.get();
		} else {
			return null;
		}
	}
	
	// PARTE 2
	public Cancion agregarCancion(Cancion nuevaCancion) {
		return repositorioCanciones.save(nuevaCancion);
	}
	
}
