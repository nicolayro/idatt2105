package no.ntnu.calculator.controller;

import no.ntnu.calculator.model.Calculation;
import no.ntnu.calculator.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/calculate")
@CrossOrigin("http://localhost:8080")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping
    public ResponseEntity<BigDecimal> calculate(@RequestBody Calculation calculation) {
        if(calculation == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(calculatorService.handleCalculation(calculation), HttpStatus.OK);
    }
}
