package com.musica.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.musica.modelos.Cancion;

@Repository
public interface RepositorioCanciones extends JpaRepository<Cancion, Long>{

}

