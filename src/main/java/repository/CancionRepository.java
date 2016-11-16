package repository;

import java.util.Collection;

import domain.Cancion;
import domain.Usuario;

public interface CancionRepository extends BaseRepository<Cancion, Long> {
	
	Cancion findById(Long id);
	Collection<Cancion> findByName(String name);
	Collection<Cancion> topTen();
	Collection<Cancion> findByAlbumId(Long albumId);
	Collection<Cancion> topCien();
}
