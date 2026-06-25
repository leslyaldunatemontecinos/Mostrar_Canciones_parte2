package com.musica.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.musica.modelos.Artista;
import com.musica.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
	
	@Autowired
	private RepositorioArtistas repoArtistas;
	
	public List<Artista> obtenerTodosLosArtistas(){
		return repoArtistas.findAll();
   }
	
	public Artista obtenerArtistaPorId(Long id) {
		Optional<Artista> optionalArtista = repoArtistas.findById(id);
		return optionalArtista.orElse(null);
	}
	
	public Artista agregarArtista(Artista artista) {
		return repoArtistas.save(artista);
	}
}