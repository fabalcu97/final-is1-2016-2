package service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.CancionRepository;
import domain.Cancion;

@Service
public class CancionService {

	@Autowired
	CancionRepository cancionRepository;
	
	@Transactional
	public void save(Cancion cancion) {
		cancionRepository.persist(cancion);
	}
	
	public Collection<Cancion> getCanciones(){
		return cancionRepository.getTodo();
	}
}
