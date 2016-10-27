package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.AccountRepository;
import repository.OperationRepository;
import domain.Account;
import domain.Operation;
import domain.Operation.Type;

@Service
public class TransferService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	OperationRepository operationRepository;

	public TransferService() {
	}

	@Transactional
	public boolean transfer(String sourceNumber, String targetNumber, double amount) {
		Account sourceAccount = accountRepository.findByNumber(sourceNumber);
		Account targetAccount = accountRepository.findByNumber(targetNumber);
		if (sourceAccount == null || targetAccount == null) {
			System.err.println("No se puede transferir por que no existe una cuenta");
			return false;
		}
		if (sourceAccount.getBalance() >= amount) {
			Operation operation = new Operation();
			sourceAccount.setBalance(sourceAccount.getBalance() - amount);
			targetAccount.setBalance(targetAccount.getBalance() + amount);

			operation.setDate(new Date());
			operation.setSourceAccount(sourceAccount);
			operation.setTargetAccount(targetAccount);
			operation.setType(Type.TRANSFER);

			accountRepository.persist(sourceAccount);
			accountRepository.persist(targetAccount);
			operationRepository.persist(operation);

			return true;
		}
		return false;
	}
}
