package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.AlbumRepository;
import repository.PlaylistRepository;
import domain.Album;
import domain.Cancion;
import domain.Playlist;
import domain.Usuario;

@Repository
public class jpaPlaylistRepository extends JpaBaseRepository<Playlist, Long> implements PlaylistRepository{

	@Override
	public Playlist findById(Long id) {
		String jpaQuery = "SELECT a FROM Playlist a WHERE a.id = :id";
		TypedQuery<Playlist> query = entityManager.createQuery(jpaQuery, Playlist.class);
		query.setParameter("id", id);
		return getFirstResult(query);
	}

	@Override
	public Collection<Playlist> getPlaylistsOfUser(Long id) {
		String jpaQuery = "SELECT a FROM Playlist a WHERE a.autor = :id";
		TypedQuery<Playlist> query = entityManager.createQuery(jpaQuery, Playlist.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public Collection<Cancion> getCancionesOfPlaylist(Long id) {
		String jpaQuery = "SELECT a FROM Cancion a, IN(a.playlistSongs) b WHERE b.id = :id";
		TypedQuery<Cancion> query = entityManager.createQuery(jpaQuery, Cancion.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	

}