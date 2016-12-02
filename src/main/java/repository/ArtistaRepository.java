package repository;

import domain.Artista;
import domain.Usuario;

public interface ArtistaRepository extends BaseRepository<Artista, Long>{
	
	Artista findById(Long id);
	
	Artista login(String correo, String contraseña);
	

}
