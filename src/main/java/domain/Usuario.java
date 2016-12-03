package domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends Person implements BaseEntity<Long>{

	@Column(nullable = false)
	private boolean activo;
	
	@OneToMany(mappedBy = "autor")
	private Collection<Playlist> playlists;
	
	@ManyToMany
    @JoinTable(name="cancion_usuario")
	private Collection<Cancion> favoritas;
	
	@ManyToMany(mappedBy = "AUsuariosSeguidos")
	private Collection<Artista> UArtistasSeguidores;
	@ManyToMany
    @JoinTable(name="usuario_seguidos_aseguidores")
	private Collection<Artista> UArtistasSeguidos;
	
	@ManyToMany(mappedBy = "UUsuariosSeguidos")
	private Collection<Usuario> UUsuariosSeguidores;
	@ManyToMany
    @JoinTable(name="usuario_useguidos_useguidores")
	private Collection<Usuario> UUsuariosSeguidos;
	
	@Override
	public Long getId() {
		
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Collection<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Collection<Playlist> playlists) {
		this.playlists = playlists;
	}

	public Collection<Cancion> getFavoritas() {
		return favoritas;
	}

	public void setFavoritas(Collection<Cancion> favoritas) {
		this.favoritas = favoritas;
	}

	public Collection<Artista> getUArtistasSeguidores() {
		return UArtistasSeguidores;
	}

	public void setUArtistasSeguidores(Collection<Artista> uArtistasSeguidores) {
		UArtistasSeguidores = uArtistasSeguidores;
	}

	public Collection<Artista> getUArtistasSeguidos() {
		return UArtistasSeguidos;
	}

	public void setUArtistasSeguidos(Collection<Artista> uArtistasSeguidos) {
		UArtistasSeguidos = uArtistasSeguidos;
	}

	public Collection<Usuario> getUUsuariosSeguidores() {
		return UUsuariosSeguidores;
	}

	public void setUUsuariosSeguidores(Collection<Usuario> uUsuariosSeguidores) {
		UUsuariosSeguidores = uUsuariosSeguidores;
	}

	public Collection<Usuario> getUUsuariosSeguidos() {
		return UUsuariosSeguidos;
	}

	public void setUUsuariosSeguidos(Collection<Usuario> uUsuariosSeguidos) {
		UUsuariosSeguidos = uUsuariosSeguidos;
	}
	
	
}
