package pl.edu.pw.elka.bdbt.athleticsclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.SalaryRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Salary;

import java.util.List;

@Controller
@RequestMapping("/salaries")
public class SalaryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);
    private final SalaryRepository salaryRepository;

    public SalaryController(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @GetMapping
    ResponseEntity<List<Salary>> getAll() {
        LOGGER.info("Showing all the records in Salaries entity!");
        return ResponseEntity.ok(salaryRepository.findAll());
    }
}
