package no.ntnu.calculator.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calculates strings of numbers
 */
@Component
public class Calculator {

    public BigDecimal calculate(Calculation calculation) {
        return switch (calculation.getOperand()) {
            case "+" -> add(calculation.getA(), calculation.getB());
            case "-" -> subtract(calculation.getA(), calculation.getB());
            case "x" -> multiply(calculation.getA(), calculation.getB());
            case "/" -> divide(calculation.getA(), calculation.getB());
            default -> throw new IllegalStateException(String.format("Unhandled operand %s", calculation.getOperand()));
        };
    }

    private BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    private BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    private BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    private BigDecimal divide(BigDecimal a, BigDecimal b) {
        if(b.compareTo(BigDecimal.ZERO) == 0) {
            return null;
        }
        return a.divide(b, 7, RoundingMode.HALF_UP);
    }
}
