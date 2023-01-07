package pl.edu.pw.elka.bdbt.athleticsclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.WorkerRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Worker;
import pl.edu.pw.elka.bdbt.athleticsclub.model.dto.WorkerDTO;
import pl.edu.pw.elka.bdbt.athleticsclub.service.WorkerService;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);
    private final WorkerRepository workerRepository;
    private final WorkerService workerService;

    public WorkerController(WorkerRepository workerRepository, WorkerService workerService) {
        this.workerRepository = workerRepository;
        this.workerService = workerService;
    }

    @GetMapping("/db")
    ResponseEntity<List<Worker>> showAll() {
        var list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    String workerPage() {
        return "/worker";
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        LOGGER.info("Showing all the records in Workers entity!");
        model.addAttribute("workers", workerRepository.findAll());
        return "/worker";
    }

    @PostMapping("/create")
    String createWorker(@RequestParam(name = "workerName") String workerName, @RequestParam(name = "workerSurname") String workerSurname) {
        LOGGER.info("Getting info: " + workerName + " " + workerSurname);
        return "/worker";
    }

    @GetMapping("/sort")
    ResponseEntity<String> sortByArgs() {
        return ResponseEntity.ok(workerService.feature1());
    }

    @GetMapping("/sortview")
    String sortBy(Model model) {
        model.addAttribute("counter", workerService.feature1());
        return "/worker";
    }

    @GetMapping("/salary")
    ResponseEntity<List<WorkerDTO>> salary() {
        var list = workerRepository.findAllByOrderByWorkerSalaryAsc().stream().map(
                WorkerDTO::toWorkerDTO
        ).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/salaryview")
    String salaryView(Model model) {
        model.addAttribute("workers", workerRepository.findAllByOrderByWorkerSalaryAsc());
        return "/worker";
    }
}
