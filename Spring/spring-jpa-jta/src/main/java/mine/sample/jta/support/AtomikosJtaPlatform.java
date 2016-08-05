package mine.sample.jta.support;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;
import org.springframework.transaction.jta.JtaTransactionManager;

public class AtomikosJtaPlatform extends AbstractJtaPlatform {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static TransactionManager sTransactionManager;
    private static UserTransaction sUserTransaction;

    @Override
    protected TransactionManager locateTransactionManager() {
        return sTransactionManager;
    }

    @Override
    protected UserTransaction locateUserTransaction() {
        return sUserTransaction;
    }

    public void setJtaTransactionManager(JtaTransactionManager jtaTransactionManager) {
        sTransactionManager = jtaTransactionManager.getTransactionManager();
        sUserTransaction = jtaTransactionManager.getUserTransaction();
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        sTransactionManager = transactionManager;
    }

    public void setUserTransaction(UserTransaction userTransaction) {
        sUserTransaction = userTransaction;
    }

}
