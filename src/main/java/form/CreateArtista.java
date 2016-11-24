package form;

import java.util.Collection;

import domain.Artista;

public class CreateArtista {
	private Collection<Long> ownerIds;

	private Artista artista;

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
}
