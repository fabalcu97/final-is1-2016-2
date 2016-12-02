package service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.AlbumRepository;
import domain.Album;
import domain.Artista;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository albumRepository;
	
	@Transactional
	public boolean save(Album album ){
		if( albumRepository.findById(album.getId()) != null ){
			return false;
		}
		albumRepository.persist(album);
		return true;
	}
	
	public Collection<Album> getAll(){
		return albumRepository.getAll();
	}
	
	public Album get(Long id) {
		return albumRepository.find(id);
	}
}
