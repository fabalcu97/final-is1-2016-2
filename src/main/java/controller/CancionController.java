package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Cancion;
import repository.CancionRepository;
import service.CancionService;


@Controller
public class CancionController {

	@Autowired
	CancionRepository cancionRepository;
	@Autowired
	CancionService cancionService;

	@RequestMapping(value = "/agregar-cancion", method = RequestMethod.GET)
	String saveCancion(ModelMap model){
		return "agregar-cancion";
	}
}
