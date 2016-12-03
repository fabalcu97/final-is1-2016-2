package domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlist")
public class Playlist extends ListaCanciones implements BaseEntity<Long> {

	@ManyToOne
	private Usuario	autor;
	
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;		
	}	

	@ManyToMany
    @JoinTable(name="playlist_cancion")
	private Collection<Cancion> canciones;

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Collection<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(Collection<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	
}
