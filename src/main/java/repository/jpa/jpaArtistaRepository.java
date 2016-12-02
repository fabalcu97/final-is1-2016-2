package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.ArtistaRepository;
import domain.Artista;
import domain.Usuario;


@Repository
public class jpaArtistaRepository extends JpaBaseRepository<Artista, Long> implements ArtistaRepository{

	@Override
	public Artista findById(Long id) {
		String jpaQuery = "SELECT a FROM Artista a WHERE a.id = :id";
		TypedQuery<Artista> query = entityManager.createQuery(jpaQuery, Artista.class);
		query.setParameter("id", id);
		return getFirstResult(query);

	}

	@Override
	public Artista login(String correo, String contraseña) {
		String jpaQuery = "SELECT a FROM Artista a WHERE a.correo = :correo AND a.contraseña = :contraseña";
		TypedQuery<Artista> query = entityManager.createQuery(jpaQuery, Artista.class);
		query.setParameter("correo", correo);
		query.setParameter("contraseña", contraseña);
		return getFirstResult(query);
	}
}
