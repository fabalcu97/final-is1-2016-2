package repository;

import java.util.Collection;

import domain.Cancion;

public interface CancionRepository extends BaseRepository<Cancion, Long> {
	
	Collection<Cancion> topTen();
}
