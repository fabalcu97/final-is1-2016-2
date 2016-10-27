package controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.PersonService;
import domain.Person;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	String savePerson(@ModelAttribute Person person, ModelMap model) {
		System.out.println("savving: " + person.getId());
		personService.save(person);
		return showPerson(person.getId(), model);
	}
	@RequestMapping(value = "/add-person", method = RequestMethod.GET)
	String addNewPerson(@RequestParam(required = false) Long id, ModelMap model) {
		Person person = id == null ? new Person() : personService.get(id);
		model.addAttribute("person", person);
		return "add-person";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	String showPerson(@RequestParam(required = false) Long id, ModelMap model) {
		if (id != null) {
			Person person = personService.get(id);
			model.addAttribute("person", person);
			return "person";
		} else {
			Collection<Person> people = personService.getAll();
			model.addAttribute("people", people);
			return "people";
		}
	}

}
