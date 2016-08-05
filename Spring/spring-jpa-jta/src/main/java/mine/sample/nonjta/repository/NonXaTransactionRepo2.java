package mine.sample.nonjta.repository;

import mine.sample.nonjta.entity.NonXaTransactionEntity2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NonXaTransactionRepo2 extends JpaRepository<NonXaTransactionEntity2, Long> {

}
