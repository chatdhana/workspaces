package mine.sample.jta.repository;

import mine.sample.jta.entity.XaTransactionEntity2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface XaTransactionRepo2 extends JpaRepository<XaTransactionEntity2, Long> {

}
