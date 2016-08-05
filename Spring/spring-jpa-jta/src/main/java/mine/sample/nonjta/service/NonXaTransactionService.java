package mine.sample.nonjta.service;

import mine.sample.nonjta.dto.NonXaTransactionDto1;
import mine.sample.nonjta.dto.NonXaTransactionDto2;

public interface NonXaTransactionService {
    void doXaTransaction();

    void doXaTransaction(NonXaTransactionDto1 dto1, NonXaTransactionDto2 dto2);

}
