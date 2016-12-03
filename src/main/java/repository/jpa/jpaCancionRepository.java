package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.CancionRepository;
import domain.Account;
import domain.Cancion;
import domain.Usuario;

@Repository
public class jpaCancionRepository extends JpaBaseRepository<Cancion, Long> implements CancionRepository {

	@Override
	public Cancion findById(Long id) {
		String jpaQuery = "SELECT a FROM Cancion a WHERE a.id = :id";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		query.setParameter("id", id);
		return getFirstResult(query);
	}
	
	@Override
	public Collection<Cancion> topTen() {
		//SELECT a.id, a.number, a.date FROM tbl_account a WHERE a.number = :number
		String jpaQuery = "SELECT a FROM Cancion a ORDER BY a.calificacion_prom DESC";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		return query.setMaxResults(10).getResultList();
	}
	
	@Override
	public Collection<Cancion> getTodo() {
		String jpaQuery = "SELECT c FROM Cancion c";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		return query.getResultList();
	}

	@Override
	public Collection<Cancion> findByName(String name) {
		String jpaQuery = "SELECT a FROM Cancion a WHERE a.nombre = :nombre";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public Collection<Cancion> findByAlbumId(Long albumId) {
		String jpaQuery = "SELECT a FROM Cancion a JOIN a.albumSongs p WHERE p.id = :albumId";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		query.setParameter("albumId", albumId);
		return query.getResultList();
	}

	@Override
	public Collection<Cancion> topCien() {
		String jpaQuery = "SELECT a FROM Cancion a ORDER BY a.reproducciones DESC LIMIT 100";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		return query.getResultList();
	}

	@Override
	public void update_rep(Long id, int rep) {
		String jpaQuery = "UPDATE FROM Cancion a SET a.reproducciones = :rep WHERE a.id = :id";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		query.setParameter("id", id);
		query.setParameter("rep", rep);
		return;
	}

}
