package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.AlbumRepository;

import domain.Album;
import domain.Cancion;

@Repository
public class jpaAlbumRepository extends JpaBaseRepository<Album, Long> implements AlbumRepository{

	@Override
	public Album findById(Long id) {
		String jpaQuery = "SELECT a FROM Album a WHERE a.id = :id";
		TypedQuery<Album> query = entityManager.createQuery(jpaQuery, Album.class);
		query.setParameter("id", id);
		return getFirstResult(query);
	}
	
	@Override
	public Collection<Album> getAll() {
		String jpaQuery = "SELECT a FROM Album a";
		TypedQuery<Album> query = entityManager.createQuery(jpaQuery, Album.class);
		return query.getResultList();
	}
	
	@Override
	public Collection<Album> findByName(String name) {
		String jpaQuery = "SELECT a FROM Album a WHERE a.nombre = :nombre";
		TypedQuery<Album> query = entityManager.createQuery(jpaQuery, Album.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
}
