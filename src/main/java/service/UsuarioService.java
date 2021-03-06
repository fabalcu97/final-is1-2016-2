package service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Artista;
import domain.Usuario;
import repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Transactional
	public boolean save(Usuario usuario) {
		if( usuarioRepository.findById(usuario.getId()) != null){
			return false;
		}
		usuarioRepository.persist(usuario);
		return true;
	}
	
	public Usuario get(Long id) {
		return usuarioRepository.find(id);
	}
	
	public Collection<Usuario> getAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario login(String correo, String contraseña) {
		return usuarioRepository.login(correo,contraseña);
	}

}
