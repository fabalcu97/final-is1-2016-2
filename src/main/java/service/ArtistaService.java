package service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Artista;
import repository.ArtistaRepository;

@Service

public class ArtistaService {

	@Autowired
	ArtistaRepository artistaRepository;
	
	@Transactional
	public void save(Artista artista) {
		artistaRepository.persist(artista);
	}
	
	public Collection<Artista> getArtistas() {
		return artistaRepository.findAll();
	}
}
