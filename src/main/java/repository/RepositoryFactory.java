package repository;

public interface RepositoryFactory {
	AccountRepository createAccountRepository();
	PersonRepository createPersonRepository();
}
