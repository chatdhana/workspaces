package mine.sample.jta.service;

import java.util.List;

import mine.sample.jta.dto.XaTransactionDto1;
import mine.sample.jta.dto.XaTransactionDto2;
import mine.sample.jta.entity.XaTransactionEntity1;
import mine.sample.jta.entity.XaTransactionEntity2;
import mine.sample.jta.repository.XaTransactionRepo1;
import mine.sample.jta.repository.XaTransactionRepo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class XaTransactionServiceImpl implements XaTransactionService {
    private Logger logger = LoggerFactory.getLogger(XaTransactionServiceImpl.class);
    @Autowired
    private XaTransactionRepo1 repo1;

    @Autowired
    private XaTransactionRepo2 repo2;

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
    public void doXaTransaction(XaTransactionDto1 dto1, XaTransactionDto2 dto2) {
        logger.info("### Querying entity1...");
        List<XaTransactionEntity1> fetchedEntity1List = repo1.findAll();
        logger.info("### Queried entity1...:" + fetchedEntity1List);

        logger.info("### Persisting entity1...");
        XaTransactionEntity1 persistedEntity1 = repo1.save(getEntity1(dto1));
        logger.info("### Persisted entity1...:" + persistedEntity1);

        logger.info("### Persisting entity2...");
        XaTransactionEntity2 persistedEntity2 = repo2.save(getEntity2(dto2));
        logger.info("### Persisted entity2...:" + persistedEntity2);
    }

    private XaTransactionEntity1 getEntity1() {
        XaTransactionEntity1 entity = new XaTransactionEntity1();
        entity.setField1("field1");
        return entity;
    }

    private XaTransactionEntity2 getEntity2() {
        XaTransactionEntity2 entity = new XaTransactionEntity2();
        entity.setField1("field1");
        return entity;
    }

    private XaTransactionEntity1 getEntity1(XaTransactionDto1 dto1) {
        XaTransactionEntity1 entity = new XaTransactionEntity1();
        entity.setField1(dto1.getTxn1Field1());
        return entity;
    }

    private XaTransactionEntity2 getEntity2(XaTransactionDto2 dto2) {
        XaTransactionEntity2 entity = new XaTransactionEntity2();
        entity.setField1(dto2.getTxn2Field1());
        return entity;
    }
}
