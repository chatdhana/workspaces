package mine.sample.nonjta.service;

import java.util.List;

import mine.sample.nonjta.dto.NonXaTransactionDto1;
import mine.sample.nonjta.dto.NonXaTransactionDto2;
import mine.sample.nonjta.entity.NonXaTransactionEntity1;
import mine.sample.nonjta.entity.NonXaTransactionEntity2;
import mine.sample.nonjta.repository.NonXaTransactionRepo1;
import mine.sample.nonjta.repository.NonXaTransactionRepo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NonXaTransactionServiceImpl implements NonXaTransactionService {
    private Logger logger = LoggerFactory.getLogger(NonXaTransactionServiceImpl.class);
    @Autowired
    private NonXaTransactionRepo1 repo1;

    @Autowired
    private NonXaTransactionRepo2 repo2;

    @Transactional(readOnly = false, propagation = Propagation.NESTED)
    public void doXaTransaction() {
        logger.info("### Persisting entity1...");
        repo1.save(getEntity1());
        logger.info("### Persisted entity1...");

        logger.info("### Persisting entity2...");
        repo2.save(getEntity2());
        logger.info("### Persisted entity2...");
    }

    @Transactional(readOnly = false, propagation = Propagation.NESTED)
    public void doXaTransaction(NonXaTransactionDto1 dto1, NonXaTransactionDto2 dto2) {
        logger.info("### Querying entity1...");
        List<NonXaTransactionEntity1> fetchedEntity1List = repo1.findAll();
        logger.info("### Queried entity1...:" + fetchedEntity1List);

        logger.info("### Persisting entity1...");
        NonXaTransactionEntity1 persistedEntity1 = repo1.save(getEntity1(dto1));
        logger.info("### Persisted entity1...:" + persistedEntity1);

        logger.info("### Persisting entity2...");
        NonXaTransactionEntity2 persistedEntity2 = repo2.save(getEntity2(dto2));
        logger.info("### Persisted entity2...:" + persistedEntity2);
    }

    private NonXaTransactionEntity1 getEntity1() {
        NonXaTransactionEntity1 entity = new NonXaTransactionEntity1();
        entity.setField1("field1");
        return entity;
    }

    private NonXaTransactionEntity2 getEntity2() {
        NonXaTransactionEntity2 entity = new NonXaTransactionEntity2();
        entity.setField1("field1");
        return entity;
    }

    private NonXaTransactionEntity1 getEntity1(NonXaTransactionDto1 dto1) {
        NonXaTransactionEntity1 entity = new NonXaTransactionEntity1();
        entity.setField1(dto1.getTxn1Field1());
        return entity;
    }

    private NonXaTransactionEntity2 getEntity2(NonXaTransactionDto2 dto2) {
        NonXaTransactionEntity2 entity = new NonXaTransactionEntity2();
        entity.setField1(dto2.getTxn2Field1());
        return entity;
    }
}
