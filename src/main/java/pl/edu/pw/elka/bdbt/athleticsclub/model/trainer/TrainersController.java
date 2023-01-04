package pl.edu.pw.elka.bdbt.athleticsclub.model.trainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.model.worker.WorkerController;

import java.util.List;

@Controller
@RequestMapping("/trainers")
public class TrainersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);
    private final TrainersRepository trainersRepository;

    public TrainersController(TrainersRepository trainersRepository) {
        this.trainersRepository = trainersRepository;
    }

    @GetMapping
    ResponseEntity<List<Trainers>> getAll() {
        LOGGER.info("Showing all the records in Trainers entity!");
        return ResponseEntity.ok(trainersRepository.findAll());
    }
}
