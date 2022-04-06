package no.ntnu.calculator.service;

import no.ntnu.calculator.model.Calculation;
import no.ntnu.calculator.model.User;
import no.ntnu.calculator.repository.CalculationRepository;
import no.ntnu.calculator.util.Calculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service class for calculator
 */
@Service
public class CalculationService {
    private final Calculator calculator;
    private final CalculationRepository calculationRepository;

    public CalculationService(Calculator calculator, CalculationRepository calculationRepository) {
        this.calculator = calculator;
        this.calculationRepository = calculationRepository;
    }

    public List<Calculation> getAllCalculations(User user) {
        return calculationRepository.findAllByUser(user);
    }

    /**
     * Takes in a calculation and calculates it
     *
     * @return result of calculation
     */
    public Calculation handleCalculation(Calculation calculation, User user) {
        calculation.setResult(calculator.calculate(calculation));
        calculation.setUser(user);
        return calculationRepository.save(calculation);
    }
}