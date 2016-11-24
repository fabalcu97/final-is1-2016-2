package repository;

import java.util.Collection;

import domain.Album;
import domain.Cancion;

public interface AlbumRepository extends BaseRepository<Album, Long> {
	
	Album findById(Long id);
	Collection<Album> getAll();
	Collection<Album> findByName(String name);
	
}
