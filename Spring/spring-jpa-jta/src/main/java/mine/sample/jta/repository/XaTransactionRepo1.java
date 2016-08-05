package mine.sample.jta.repository;

import mine.sample.jta.entity.XaTransactionEntity1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface XaTransactionRepo1 extends JpaRepository<XaTransactionEntity1, Long> {

}
