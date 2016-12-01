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
import domain.Artista;
import repository.ArtistaRepository;
import service.ArtistaService;

@Controller
public class ArtistaController {

	@Autowired
	ArtistaRepository artistaRepository;
	@Autowired
	ArtistaService artistaService;
		
	@RequestMapping(value = "/artista", method = RequestMethod.POST)
	String saveArtista(@ModelAttribute Artista artista, ModelMap model) {
		System.out.println("saving: " + artista.getId());
		artistaService.save(artista);
		return showArtista(artista.getId(), model);
	}
	@RequestMapping(value = "/agregar-artista", method = RequestMethod.GET)
	String addNewPerson(@RequestParam(required = false) Long id, ModelMap model) {
		Artista artista = id == null ? new Artista() : artistaService.get(id);
		model.addAttribute("artista", artista);
		return "agregar-artista";
	}

	@RequestMapping(value = "/artista", method = RequestMethod.GET)
	String showArtista(@RequestParam(required = false) Long id, ModelMap model) {
		if (id != null) {
			Artista artista = artistaService.get(id);
			model.addAttribute("artista", artista);
			return "artista";
		} else {
			Collection<Artista> artistas = artistaService.getAll();
			model.addAttribute("artistas", artistas);
			return "artistas";
		}
	}
	
	
}