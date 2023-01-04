package pl.edu.pw.elka.bdbt.athleticsclub.model.salary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.model.owner.OwnersController;

import java.util.List;

@Controller
@RequestMapping("/salaries")
public class SalariesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnersController.class);
    private final SalariesRepository salariesRepository;

    public SalariesController(SalariesRepository salariesRepository) {
        this.salariesRepository = salariesRepository;
    }

    @GetMapping
    ResponseEntity<List<Salaries>> getAll() {
        LOGGER.info("Showing all the records in Salaries entity!");
        return ResponseEntity.ok(salariesRepository.findAll());
    }
}
