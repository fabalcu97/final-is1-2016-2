package service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Artista;
import domain.Usuario;
import repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	ArtistaRepository artistaRepository;
	
	@Transactional
	public boolean save(Artista artista ){
		if( artistaRepository.findById(artista.getId()) != null ){
			return false;
		}
		artistaRepository.persist(artista);
		return true;
	}
	
	public Artista get(Long id) {
		return artistaRepository.find(id);
	}
	
	public Collection<Artista> getAll() {
		return artistaRepository.findAll();
	}
	
	public Artista login(String correo, String contraseña) {
		return artistaRepository.login(correo,contraseña);
	}
}
