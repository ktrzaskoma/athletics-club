package pl.edu.pw.elka.bdbt.athleticsclub.workers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/workers")
public class WorkersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkersController.class);
    private final WorkersRepository workersRepository;

    public WorkersController(WorkersRepository workersRepository) {
        this.workersRepository = workersRepository;
    }

    @GetMapping
    ResponseEntity<List<Workers>> getAll() {
        LOGGER.info("Showing all the records in Workers entity!");
        return ResponseEntity.ok(workersRepository.findAll());
    }
}
