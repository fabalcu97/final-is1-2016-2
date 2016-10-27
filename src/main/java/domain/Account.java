package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_account", indexes = { @Index(columnList = "number") })
public class Account implements BaseEntity<Long> {

	@Id
	@SequenceGenerator(name = "account_id_generator", sequenceName = "account_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_generator")
	private Long id;

	@Column(unique = true, nullable = false, updatable = false, length = 64)
	private String number;

	@Column(nullable = false)
	private double balance;

	@ManyToMany(mappedBy = "accounts")
	private Collection<Person> owners;

	@OneToMany(mappedBy = "sourceAccount", fetch = FetchType.LAZY)
	private Collection<Operation> sourceOperations;

	@OneToMany(mappedBy = "targetAccount")
	private Collection<Operation> targetOperations;

	@Column(nullable = false)
	private Date created = new Date();

	public Account() {
	}

	public Account(String number, double balance) {
		this.number = number;
		this.balance = balance;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static Account copy(Account account) {
		if (account == null) {
			return null;
		}
		Account copy = new Account();
		copy.setBalance(account.getBalance());
		copy.setNumber(account.getNumber());
		return copy;
	}

	@Override
	public String toString() {
		return "{number: " + number + ", balance: " + balance + "}";
	}

	public Collection<Person> getOwners() {
		return owners;
	}

	public void setOwners(Collection<Person> owners) {
		this.owners = owners;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
