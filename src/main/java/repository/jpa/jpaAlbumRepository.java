package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.AlbumRepository;

import domain.Album;
import domain.Cancion;

@Repository
public class jpaAlbumRepository extends JpaBaseRepository<Album, Long> implements AlbumRepository{

	

}
