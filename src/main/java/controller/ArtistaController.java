package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repository.ArtistaRepository;
import service.ArtistaService;

@Controller
public class ArtistaController {

	@Autowired
	ArtistaRepository artistaRepository;
	@Autowired
	ArtistaService artistaService;
		
	@RequestMapping(value = "/artista", method = RequestMethod.GET)
	String showArtista(ModelMap model) {
		model.addAttribute("artista", artistaService.getArtista());
		return "lista-usuarios";
	}
	
	@RequestMapping(value = "/agregar-artista", method = RequestMethod.POST)
	String saveArtista(ModelMap model){
		return "agregar-artista";
	}
	
	
}