package mine.sample.jta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "XA_TXN_ENTITY1")
public class XaTransactionEntity1 extends AbstractPersistable<Long>{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "FIELD1", nullable = true)
    private String field1;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

}
