package repository;

import java.util.Collection;

import domain.Cancion;
import domain.Usuario;

public interface CancionRepository extends BaseRepository<Cancion, Long> {
	
	Cancion findById(Long id);
	Cancion findByName(String nombre);
	Collection<Cancion> topTen();
	Collection<Cancion> getTodo();
	Collection<Cancion> findByAlbumId(Long albumId);
	Collection<Cancion> topCien();
	void update_rep(Long id, int rep);
}
