package controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Album;
import repository.AlbumRepository;
import service.AlbumService;


@Controller
public class AlbumController {

	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	AlbumService albumService;
	
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	String saveAlbum(@ModelAttribute Album album, ModelMap model) {
		System.out.println("saving: " + album.getId());
		albumService.save(album);
		return showAlbum(album.getId(), model);
	}
	@RequestMapping(value = "/agregar-album", method = RequestMethod.GET)
	String addNewAlbum(@RequestParam(required = false) Long id, ModelMap model) {
		Album album = id == null ? new Album() : albumService.get(id);
		model.addAttribute("album", album);
		return "agregar-album";
	}

	@RequestMapping(value = "/album", method = RequestMethod.GET)
	String showAlbum(@RequestParam(required = false) Long id, ModelMap model) {
		if (id != null) {
			Album album = albumService.get(id);
			model.addAttribute("album", album);
			return "album";
		} else {
			Collection<Album> albumes = albumService.getAll();
			model.addAttribute("albumes", albumes);
			return "album-list";
		}
	}
	
}
