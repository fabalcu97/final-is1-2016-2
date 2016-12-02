package repository;

import domain.Usuario;

public interface UsuarioRepository extends BaseRepository<Usuario, Long>{
	
	Usuario findById(Long id);

	Usuario login(String correo, String contraseña);

}
