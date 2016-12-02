package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/add-usuario", method = RequestMethod.POST)
	String saveAccount(@ModelAttribute Usuario usuario, ModelMap model) {
		usuarioService.save(usuario);
		model.addAttribute("usuarios", usuarioService.getUsuarios());
		return "agregar-usuario";
	}
		
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	String showUsuario(ModelMap model) {
		model.addAttribute("usuarios", usuarioService.getUsuarios());
		return "lista-usuarios";
	}
	
	
}