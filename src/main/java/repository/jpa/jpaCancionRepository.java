package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.CancionRepository;
import domain.Cancion;

@Repository
public class jpaCancionRepository extends JpaBaseRepository<Cancion, Long> implements CancionRepository {

	
	@Override
	public Collection<Cancion> topTen() {
		//SELECT a.id, a.number, a.date FROM tbl_account a WHERE a.number = :number
		String jpaQuery = "SELECT a FROM Cancion a ORDER BY a.reproducciones DESC LIMIT 10";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		return query.getResultList();
	}

}
