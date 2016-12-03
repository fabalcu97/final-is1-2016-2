package domain;

import java.util.Collection;
import java.util.Date;
import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;


@Entity
public class Cancion implements BaseEntity<Long>{
	
	@Id
	@SequenceGenerator(name = "cancion_id_generator", sequenceName = "cancion_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancion_id_generator")
	private Long id;
	
	@Column(length = 64)
	private String nombre;
	
	@ManyToMany(mappedBy = "favoritas")
	private Collection<Usuario> usuarios;
	
	@Column(nullable = false)
	private Date fecha = new Date();
	
	@Column(nullable = false)
	private double calificacion_prom;
	
	@Column(nullable = false)
	private int reproducciones;

	@Column(name="audio")
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] file;
	
	@Column(length = 64)
	private String genero;
	@ManyToMany(mappedBy = "canciones")
	private Collection<Playlist> albumSongs;
	
	@ManyToMany(mappedBy = "canciones")
	private Collection<Album> playlistSongs;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getCalificacion_prom() {
		return calificacion_prom;
	}

	public void setCalificacion_prom(double calificacion_prom) {
		this.calificacion_prom = calificacion_prom;
	}

	public int getReproducciones() {
		return reproducciones;
	}

	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Collection<Playlist> getAlbumSongs() {
		return albumSongs;
	}

	public void setAlbumSongs(Collection<Playlist> albumSongs) {
		this.albumSongs = albumSongs;
	}

	public Collection<Album> getPlaylistSongs() {
		return playlistSongs;
	}

	public void setPlaylistSongs(Collection<Album> playlistSongs) {
		this.playlistSongs = playlistSongs;
	}
	
	
}
