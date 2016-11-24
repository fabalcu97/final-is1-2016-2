package repository.jpa;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.UsuarioRepository;
import domain.Usuario;


@Repository
public class jpaUsuarioRepository extends JpaBaseRepository<Usuario, Long> implements UsuarioRepository{

	@Override
	public Usuario findById(Long id) {
		String jpaQuery = "SELECT a FROM Usuario a WHERE a.id = :id";
		TypedQuery<Usuario> query = entityManager.createQuery(jpaQuery, Usuario.class);
		query.setParameter("id", id);
		return getFirstResult(query);
		//falta ultimas canciones reproducidas
	}

}
