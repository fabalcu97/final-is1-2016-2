package service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.AlbumRepository;
import domain.Album;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository albumRepository;

	public Collection<Album> getAlbumes(){
		return albumRepository.getAll();
	}
}
