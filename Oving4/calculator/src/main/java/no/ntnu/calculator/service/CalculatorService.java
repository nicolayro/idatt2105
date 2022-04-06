package no.ntnu.calculator.service;

import no.ntnu.calculator.model.Calculation;
import no.ntnu.calculator.model.Calculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Service class for calculator
 */
@Service
public class CalculatorService {
    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Takes in a calculation and calculates it
     *
     * @return result of calculation
     */
    public BigDecimal handleCalculation(Calculation calculation) {
        return calculator.calculate(calculation);
    }
}
