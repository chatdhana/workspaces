package mine.sample.jta.service;

import mine.sample.jta.dto.XaTransactionDto1;
import mine.sample.jta.dto.XaTransactionDto2;

public interface XaTransactionService {
    void doXaTransaction();

    void doXaTransaction(XaTransactionDto1 dto1, XaTransactionDto2 dto2);

}
