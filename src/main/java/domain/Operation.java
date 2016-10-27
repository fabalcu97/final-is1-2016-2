package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Operation implements BaseEntity<Long> {
	public enum Type {
		WITHDRAW, DEPOSIT, TRANSFER
	}
	
	@Id
	@SequenceGenerator(name = "operation_id_generator", sequenceName = "operation_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_id_generator")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	private Date date;

	@ManyToOne
	private Account sourceAccount;
	
	@ManyToOne
	private Account targetAccount;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Account getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}
}
