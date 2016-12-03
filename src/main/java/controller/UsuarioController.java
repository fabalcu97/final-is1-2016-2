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
import service.ArtistaService;
import service.CancionService;
import service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ArtistaService artistaService;
	
	@Autowired
	CancionService cancionService;
	
	String homeAdmin(ModelMap model){
		return "home-admin";
	}
	
	@RequestMapping(value = "/mejores-canciones", method = RequestMethod.GET)
	String mejoresCanciones(ModelMap model){
		model.addAttribute("canciones", cancionService.getMejores());
		return "mejores-canciones";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	String login(@ModelAttribute Usuario usuario, @ModelAttribute Artista artista, ModelMap model) {
		usuario = usuarioService.login(usuario.getCorreo(), usuario.getContraseña());
		artista = artistaService.login(artista.getCorreo(), artista.getContraseña());
		
		if(usuario==null && artista==null){
			
			usuario = new Usuario();
			artista = new Artista();
			model.addAttribute("usuario", usuario);
			model.addAttribute("artista", artista);
			return "index";
		}
		
		if(usuario==null && artista!=null){
			model.addAttribute("rank", "artista");
			
		}
		else if(artista==null && usuario!=null){
			if(usuario.getFirstName().equals("admin")){		
				return homeAdmin(model);
			}
			else{
				model.addAttribute("rank", "usuario");
			}
		}
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	String register(ModelMap model) {
		return "register";
	}
	
	@RequestMapping(value = "/usuario-list", method = RequestMethod.GET)
	String showList(ModelMap model) {
	model.addAttribute("usuarios", usuarioService.getAll());
	return "usuario-list";			
	}
	
	
	@RequestMapping(value = "/usuario-list", method = RequestMethod.POST)
	String showList(Usuario usuario , ModelMap model) {
		System.out.println("saving: " + usuario.getId());
		usuarioService.save(usuario);
		model.addAttribute("usuarios", usuarioService.getAll());
		return "usuario-list";
				
	}
	
	
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
			return "usuario";
		}
	}
}