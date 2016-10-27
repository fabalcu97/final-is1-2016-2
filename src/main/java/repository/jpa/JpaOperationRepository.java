package repository.jpa;

import org.springframework.stereotype.Repository;

import repository.OperationRepository;
import domain.Operation;

@Repository
public class JpaOperationRepository extends JpaBaseRepository<Operation, Long> implements
		OperationRepository {
}
