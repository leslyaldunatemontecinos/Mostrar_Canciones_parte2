package com.musica.repositorios;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import io.micrometer.common.lang.NonNull;

import com.musica.modelos.Artista;

@Repository
public interface RepositorioArtistas extends ListCrudRepository<Artista, Long> {

	@NonNull
	List<Artista> findAll();
}
