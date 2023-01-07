package pl.edu.pw.elka.bdbt.athleticsclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.TrainingRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Training;
import pl.edu.pw.elka.bdbt.athleticsclub.model.dto.TrainingDTO;
import pl.edu.pw.elka.bdbt.athleticsclub.model.dto.WorkerDTO;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/training")
public class TrainingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingController.class);
    private final TrainingRepository trainingRepository;

    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @GetMapping("/db")
    ResponseEntity<List<Training>> showAll() {
        var list = trainingRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    String trainingPage() {
        return "/training";
    }

    @GetMapping("/getall")
    String getAll(Model model) {
        LOGGER.info("Showing all the records in Workers entity!");
        model.addAttribute("trainings", trainingRepository.findAll());
        return "/training";
    }


}
