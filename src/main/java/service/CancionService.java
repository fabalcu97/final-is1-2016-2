package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.FileSystemUtils;
import org.springframework.core.io.Resource;

import repository.AlbumRepository;
import repository.CancionRepository;
import domain.Album;
import domain.Cancion;

@Service
public class CancionService {

	@Autowired
	CancionRepository cancionRepository;
	
	@Transactional
	public boolean save(Cancion  cancion){
		if( cancionRepository.findById(cancion.getId()) != null ){
			return false;
		}
		cancionRepository.persist(cancion);
		return true;
	}
	
	
	public Cancion get(Long id) {
		return cancionRepository.findById(id);
	}

	public Collection<Cancion> getAll(){
		return cancionRepository.getTodo();
	}

}
