package no.ntnu.calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Contains information about a single calculation
 */
@Entity
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal a;
    private BigDecimal b;
    private String operand;

    public Calculation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public String getOperand() {
        return operand;
    }

}
