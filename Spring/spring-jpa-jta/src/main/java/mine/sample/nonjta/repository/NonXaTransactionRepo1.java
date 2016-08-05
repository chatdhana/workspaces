package mine.sample.nonjta.repository;

import mine.sample.nonjta.entity.NonXaTransactionEntity1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NonXaTransactionRepo1 extends JpaRepository<NonXaTransactionEntity1, Long> {

}
