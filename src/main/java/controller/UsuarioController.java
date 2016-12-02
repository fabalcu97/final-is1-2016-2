package controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Artista;
import domain.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	String saveUsuario(@ModelAttribute Usuario usuario, ModelMap model) {
		System.out.println("saving: " + usuario.getId());
		usuarioService.save(usuario);
		return showUsuario(usuario.getId(), model);
	}
	@RequestMapping(value = "/agregar-usuario", method = RequestMethod.GET)
	String addNewUsuario(@RequestParam(required = false) Long id, ModelMap model) {
		Usuario usuario = id == null ? new Usuario() : usuarioService.get(id);
		model.addAttribute("usuario", usuario);
		return "agregar-usuario";
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	String showUsuario(@RequestParam(required = false) Long id, ModelMap model) {
		if (id != null) {
			Usuario usuario = usuarioService.get(id);
			model.addAttribute("usuario", usuario);
			return "artista";
		} else {
			Collection<Usuario> usuarios = usuarioService.getAll();
			model.addAttribute("usuarios", usuarios);
			return "usuarios";
		}
	}
}