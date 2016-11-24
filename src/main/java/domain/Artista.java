package domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Artista extends Person implements BaseEntity<Long> {

	@Column
	private boolean activo = true;
	
	@Column
	private boolean verificado = false;
	
	@Column(length = 256)
	private String informacion;

	@ManyToMany
    @JoinTable(name="artista_album")
	private Collection<Album> albumes;
	
	/*
	 * Los seguidores de artista se basan en los
	 * seguidos de artista 
	 */
	@ManyToMany(mappedBy = "AArtistasSeguidos")
	private Collection<Artista> AArtistasSeguidores;
	@ManyToMany
    @JoinTable(name="artista_aseguidos_aseguidores")
	private Collection<Artista> AArtistasSeguidos;
	
	@ManyToMany(mappedBy = "UArtistasSeguidos")
	private Collection<Usuario> AUsuariosSeguidores;
	@ManyToMany
    @JoinTable(name="artista_aseguidos_useguidores")
	private Collection<Usuario> AUsuariosSeguidos;
	
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public Collection<Album> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(Collection<Album> albumes) {
		this.albumes = albumes;
	}

	public Collection<Artista> getAArtistasSeguidores() {
		return AArtistasSeguidores;
	}

	public void setAArtistasSeguidores(Collection<Artista> aArtistasSeguidores) {
		AArtistasSeguidores = aArtistasSeguidores;
	}

	public Collection<Artista> getAArtistasSeguidos() {
		return AArtistasSeguidos;
	}

	public void setAArtistasSeguidos(Collection<Artista> aArtistasSeguidos) {
		AArtistasSeguidos = aArtistasSeguidos;
	}

	public Collection<Usuario> getAUsuariosSeguidores() {
		return AUsuariosSeguidores;
	}

	public void setAUsuariosSeguidores(Collection<Usuario> aUsuariosSeguidores) {
		AUsuariosSeguidores = aUsuariosSeguidores;
	}

	public Collection<Usuario> getAUsuariosSeguidos() {
		return AUsuariosSeguidos;
	}

	public void setAUsuariosSeguidos(Collection<Usuario> aUsuariosSeguidos) {
		AUsuariosSeguidos = aUsuariosSeguidos;
	}

	
	
}
