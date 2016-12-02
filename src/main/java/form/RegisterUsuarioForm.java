package form;

import java.util.Collection;

import domain.Usuario;

public class RegisterUsuarioForm {
	private Collection<Long> ownerIds;

	private Usuario usuario;

	public Collection<Long> getOwnerIds() {
		return ownerIds;
	}

	public void setOwnerIds(Collection<Long> ownerIds) {
		this.ownerIds = ownerIds;
	}

	public Usuario getAccount() {
		return usuario;
	}

	public void setAccount(Usuario usuario) {
		this.usuario = usuario;
	}
}
