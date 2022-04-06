package no.ntnu.calculator.repository;

import no.ntnu.calculator.model.Calculation;
import no.ntnu.calculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculationRepository extends JpaRepository<Calculation, Long> {
    List<Calculation> findAllByUser(User user);
}
