package repository.jpa;

import org.springframework.stereotype.Repository;

import repository.PersonRepository;
import domain.Person;

@Repository
public class JpaPersonRepository extends JpaBaseRepository<Person, Long> implements
		PersonRepository {
}
