package pl.edu.pw.elka.bdbt.athleticsclub.mvc.inheritanceworker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerController;

import java.util.List;

@Controller
@RequestMapping("/trainers")
public class TrainerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);
    private final TrainerRepository trainerRepository;

    public TrainerController(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @GetMapping
    ResponseEntity<List<Trainer>> getAll() {
        LOGGER.info("Showing all the records in Trainers entity!");
        return ResponseEntity.ok(trainerRepository.findAll());
    }
}
