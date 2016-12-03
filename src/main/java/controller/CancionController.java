package controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import domain.Album;
import domain.Cancion;
import repository.AlbumRepository;
import repository.CancionRepository;
import service.AlbumService;
import service.CancionService;
import storage.FileSystemStorageService;
import storage.StorageFileNotFoundException;
import storage.StorageService;

@Controller
public class CancionController {
	
	@Autowired
	CancionRepository cancionRepository;
	@Autowired
	CancionService cancionService;

	FileSystemStorageService storageService;
	
	public String relativeWebPath = "/var/www/final-is1-2016-2/src/main/webapp/WEB-INF/uploads";
	
	@RequestMapping(value ="/uploads/{filename:.+}", method =RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		
		Path rootLocation =  Paths.get(relativeWebPath);
		try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
            	return ResponseEntity
                        .ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resource.getFilename()+"\"")
                        .body(resource);
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }
	
	@RequestMapping(value = "/cancion", method = RequestMethod.POST)
	String saveCancion(@ModelAttribute Cancion cancion, @RequestParam("file") MultipartFile file, ModelMap model) throws IOException {
		System.out.println("saving: " + cancion.getId());
		cancionService.save(cancion);
		Path rootLocation =  Paths.get(relativeWebPath);
		System.out.println(file.getOriginalFilename());
		try {
			Files.createDirectory(rootLocation);
		} catch (FileAlreadyExistsException e) {
            
        }
		Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
		//storageService.store(file);
		return showCancion(cancion.getId(), model);
	}
	
	@RequestMapping(value = "/agregar-cancion", method = RequestMethod.GET)
	String addNewCancion(@RequestParam(required = false) Long id, ModelMap model) {
		Cancion cancion = id == null ? new Cancion() : cancionService.get(id);
		model.addAttribute("cancion", cancion);
		return "agregar-cancion";
	}

	@RequestMapping(value = "/cancion", method = RequestMethod.GET)
	String showCancion(@RequestParam(required = false) Long id, ModelMap model) {
		if (id != null) {
			Cancion cancion = cancionService.get(id);
			model.addAttribute("cancion", cancion);
			
			return "cancion";
		} else {
			Collection<Cancion> canciones = cancionService.getAll();
			model.addAttribute("canciones", canciones);
			return "cancion-list";
		}
	}
	
	@RequestMapping(value = "/cancion-list", method = RequestMethod.GET)
	String reproducir(@RequestParam(required = false) Long id, ModelMap model) {
		
		if (id != null) {
			Cancion cancion = cancionService.get(id);
			Collection<Cancion> canciones = cancionService.getAll();
			cancion.setReproducciones(cancion.getReproducciones()+1);
			cancionService.save(cancion);
			//cancionService.updtae_rep(id, cancion.getReproducciones()+1);
			model.addAttribute("cancion_rep", cancion);
			model.addAttribute("canciones", canciones);
		}
		else {
			Collection<Cancion> canciones = cancionService.getAll();
			model.addAttribute("canciones", canciones);
		}
		return "cancion-list";
	}
}
