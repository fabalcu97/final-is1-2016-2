package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Playlist;
import domain.Usuario;
import repository.UsuarioRepository;
import service.PlaylistService;
import service.UsuarioService;

@Controller
public class PlaylistController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PlaylistService playlistService;

	@RequestMapping(value = "/playlist-list", method = RequestMethod.POST)
	String saveAccount(@ModelAttribute Playlist playlist, ModelMap model) {
		playlistService.save(playlist);
		model.addAttribute("playlists", playlistService.getPlaylists());
		return "playlist-list";
	}
		
	@RequestMapping(value = "/playlist-list", method = RequestMethod.GET)
	String showUsuario(ModelMap model) {
		model.addAttribute("playlists", playlistService.getPlaylists());
		return "playlist-list";
	}
	
	@RequestMapping(value = "/agregar-playlist", method = RequestMethod.GET)
	String saveUsuario(ModelMap model){
		return "agregar-playlist";
	}
	
	
}