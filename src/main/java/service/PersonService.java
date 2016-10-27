package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.PersonRepository;
import domain.Person;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Transactional
	public void save(Person person) {
		if (person.getId() == null) {
			personRepository.persist(person);
		} else {
			personRepository.merge(person);
		}
	}

	public Person get(Long id) {
		return personRepository.find(id);
	}

	public Collection<Person> getAll() {
		return personRepository.findAll();
	}
}
