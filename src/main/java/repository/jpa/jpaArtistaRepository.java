package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.ArtistaRepository;
import domain.Artista;


@Repository
public class jpaArtistaRepository extends JpaBaseRepository<Artista, Long> implements ArtistaRepository{

	@Override
	public Artista findById(Long id) {
		String jpaQuery = "SELECT a FROM artista a WHERE a.id = :id";
		TypedQuery<Artista> query = entityManager.createQuery(jpaQuery, Artista.class);
		query.setParameter("id", id);
		return getFirstResult(query);

	}
}
