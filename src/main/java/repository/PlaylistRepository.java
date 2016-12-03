package repository;

import java.util.Collection;

import domain.Album;
import domain.Cancion;
import domain.Playlist;
import domain.Usuario;

public interface PlaylistRepository extends BaseRepository<Playlist, Long> {
	Playlist findById(Long id);

	Collection<Playlist> getPlaylistsOfUser(Long id);

	Collection<Cancion> getCancionesOfPlaylist(Long id);
}