package mine.sample.nonjta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "NON_XA_TXN_ENTITY2")
public class NonXaTransactionEntity2 extends AbstractPersistable<Long> {
    private static final long serialVersionUID = 1L;

    @Column(name = "FIELD1", nullable = false)
    private String field1;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

}
