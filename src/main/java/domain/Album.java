package domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Album extends ListaCanciones implements BaseEntity<Long> {

	@ManyToMany(mappedBy = "albumes")
	private Collection<Artista> autores;
	
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;

	}
	
	@ManyToMany
    @JoinTable(name="album_cancion")
	private Collection<Cancion> canciones;

	public Collection<Artista> getAutores() {
		return autores;
	}

	public void setAutores(Collection<Artista> autores) {
		this.autores = autores;
	}

	public Collection<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(Collection<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	
}
