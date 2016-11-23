package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	String saveAccount(@ModelAttribute Artista artista, ModelMap model) {
		artistaService.save(artista);
		model.addAttribute("artistas", artistaService.getArtistas());
		return "lista-artistas";
	}
		
	@RequestMapping(value = "/artista", method = RequestMethod.GET)
	String showUsuario(ModelMap model) {
		model.addAttribute("artistas", artistaService.getArtistas());
		return "lista-artistas";
	}
	
	@RequestMapping(value = "/agregar-artista", method = RequestMethod.GET)
	String saveUsuario(ModelMap model){
		return "agregar-artista";
	}
	

}