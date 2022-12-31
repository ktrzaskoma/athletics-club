package pl.edu.pw.elka.bdbt.athleticsclub.trainings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/trainings")
public class TrainingsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingsController.class);
    private final TrainingsRepository trainingsRepository;

    public TrainingsController(TrainingsRepository trainingsRepository) {
        this.trainingsRepository = trainingsRepository;
    }

    @GetMapping
    ResponseEntity<List<Trainings>> getAll() {
        LOGGER.info("Showing all the records in SportLicenses entity!");
        return ResponseEntity.ok(trainingsRepository.findAll());
    }
}
