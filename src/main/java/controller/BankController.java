package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.AccountService;
import service.AlbumService;
import service.UsuarioService;
import service.CancionService;
import repository.UsuarioRepository;
import domain.Account;
import domain.Album;
import domain.Cancion;
import domain.Usuario;
import form.CreateAccountForm;
import form.TransferForm;

@Controller
public class BankController {

	@Autowired
	CancionService cancionService;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/canciones", method = RequestMethod.GET)
	String listCanciones(ModelMap model) {
		model.addAttribute("canciones", cancionService.getCanciones());
		return "cancion-list";
	}
	
	@RequestMapping(value = "/albumes", method = RequestMethod.GET)
	String listAlbumes(ModelMap model) {
		model.addAttribute("albumes", albumService.getAlbumes());
		return "album-list";
	}
	
	/*
	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	String showTransfer(@ModelAttribute TransferForm transfer, ModelMap model) {
		return "transfer";
	}
	*/
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	String saveAccount(@ModelAttribute Account account, ModelMap model) {
		accountService.save(account);
		return "account-list";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	String listAccounts(ModelMap model) {
		model.addAttribute("accounts", accountService.getAccounts());
		return "account-list";
	}
	

	
	@RequestMapping(value = "/add-account", method = RequestMethod.GET)
	String addAccount(ModelMap model) {
		return "add-account";
	}
	/*
	/*@RequestMapping(value = "/register-account", method = RequestMethod.POST)
	String createAccount(@ModelAttribute CreateAccountForm createAccount, ModelMap model) {
		accountService.createAccount(createAccount.getOwnerIds(), createAccount.getAccount());
		return "add-account";
	}*/

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home(ModelMap model) {
		return "home";
	}
}
