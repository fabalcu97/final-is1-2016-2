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
import domain.Cancion;
import domain.Playlist;
import domain.Usuario;
import repository.UsuarioRepository;
import service.ArtistaService;
import service.CancionService;
import service.PlaylistService;
import service.UsuarioService;

@Controller
public class PlaylistController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PlaylistService playlistService;
	@Autowired
	ArtistaService artistaService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	CancionService cancionService;
	
	@RequestMapping(value = "/playlist", method = RequestMethod.POST)
	String savePlaylist(@ModelAttribute Playlist playlist, @ModelAttribute Artista artista, @ModelAttribute Usuario usuario, ModelMap model) {
		System.out.println("saving: " + playlist.getId());
		playlistService.save(playlist);
		return showPlaylist(playlist.getId(), artista, usuario, model);
	}
	@RequestMapping(value = "/agregar-playlist", method = RequestMethod.GET)
	String addNewPlaylist(@RequestParam(required = false) Long id,  @ModelAttribute Artista artista, @ModelAttribute Usuario usuario, ModelMap model) {
		System.out.println("saving: " + usuario.getId());
		model.addAttribute("artista", artista);
		model.addAttribute("usuario", usuario);
		Playlist playlist = id == null ? new Playlist() : playlistService.get(id);
		model.addAttribute("playlist", playlist);
		return "agregar-playlist";
	}

	@RequestMapping(value = "/playlist", method = RequestMethod.GET)
	String showPlaylist(@RequestParam(required = false) Long id, @ModelAttribute Artista artista, @ModelAttribute Usuario usuario, ModelMap model) {
		System.out.println("OJO: " + usuario.getId());
		model.addAttribute("artista", artista);
		model.addAttribute("usuario", usuario);
		if (id != null) {
			Collection<Playlist> uplaylists = playlistService.getPlaylistsOfUser(usuario.getId());
			model.addAttribute("uplaylists", uplaylists);
			Collection<Cancion> canciones = playlistService.getCancionesOfPlaylist(id);
			model.addAttribute("canciones", canciones);
			
			return "cancion-list";
		} else {
			Collection<Playlist> playlists = playlistService.getPlaylists();
			model.addAttribute("playlists", playlists);
			return "playlist-list";
		}
	}
	
	@RequestMapping(value = "/agregar-a-playlist", method = RequestMethod.GET)
	String agregarCancion(@RequestParam(required = false) Long idp,@RequestParam(required = false) Long idc, @RequestParam(required = false) Long idu, @RequestParam(required = false) Long ida, ModelMap model){
		
		Artista artista = artistaService.get(ida);
		Usuario usuario = usuarioService.get(idu);
		model.addAttribute("artista", artista);
		model.addAttribute("usuario", usuario);
		
		Playlist playlist=playlistService.get(idp);
		Cancion cancion=cancionService.get(idc);
		Collection<Cancion> canciones = playlist.getCanciones();
		canciones.add(cancion);
		playlist.setCanciones(canciones);
		
		playlistService.save(playlist);
		
		return "cancion";
	}
	
}