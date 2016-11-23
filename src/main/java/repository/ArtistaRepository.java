package repository;

import domain.Artista;

public interface ArtistaRepository extends BaseRepository<Artista, Long>{
	
	Artista findById(Long id);
	
}
