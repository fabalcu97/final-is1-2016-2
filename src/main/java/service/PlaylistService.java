package service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.AccountRepository;
import repository.PlaylistRepository;
import domain.Account;
import domain.Cancion;
import domain.Person;
import domain.Playlist;
import domain.Usuario;

@Service
public class PlaylistService {

	@Autowired
	PlaylistRepository playlistRepository;
	

	@Transactional
	public void save(Playlist playlist) {
		playlistRepository.persist(playlist);
	}

	/*@Transactional
	public void createAccount(Collection<Long> ownerIds, Account account) {
		if (!ownerIds.isEmpty()) {
			Collection<Person> owners = personRepository.findByIds(ownerIds);
			account.setOwners(owners);
			accountRepository.persist(account);
		}
	}*/

	/*public Collection<Account> getAccountsByPersonId2(Long personId) {
		Person person = personRepository.find(personId);
		if (person != null) {
			return person.getAccounts();
		}
		return Collections.emptyList();
	}*/
	
	public Playlist get(Long id) {
		return playlistRepository.find(id);
	}

	public Collection<Playlist> getPlaylists() {
		return playlistRepository.findAll();
	}

	public Collection<Playlist> getPlaylistsOfUser(Long id) {
		return playlistRepository.getPlaylistsOfUser(id);
	}

	public Collection<Cancion> getCancionesOfPlaylist(Long id) {
		return playlistRepository.getCancionesOfPlaylist(id);
	}
}