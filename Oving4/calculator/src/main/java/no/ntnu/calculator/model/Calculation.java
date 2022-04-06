package no.ntnu.calculator.model;

import java.math.BigDecimal;

/**
 * Contains information about a single calculation
 */
public class Calculation {
    private BigDecimal a;
    private BigDecimal b;
    private String operand;

    public Calculation() {}

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
