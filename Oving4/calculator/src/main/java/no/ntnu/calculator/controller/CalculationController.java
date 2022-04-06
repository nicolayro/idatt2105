package no.ntnu.calculator.controller;

import no.ntnu.calculator.model.Calculation;
import no.ntnu.calculator.model.User;
import no.ntnu.calculator.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@CrossOrigin("http://localhost:8080")
public class CalculationController {
    private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);

    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/calculations")
    public ResponseEntity<List<Calculation>> getCalculations(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        logger.info("Fetching all calculations for {}", user.getUsername());
        return new ResponseEntity<>(calculationService.getAllCalculations(user), HttpStatus.OK);
    }

    @PostMapping("/calculations")
    public ResponseEntity<Calculation> calculate(@RequestBody Calculation calculation, Authentication authentication) {
        if(calculation == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = (User) authentication.getPrincipal();
        logger.info("Calculating...");
        return new ResponseEntity<>(calculationService.handleCalculation(calculation, user), HttpStatus.OK);
    }

}
