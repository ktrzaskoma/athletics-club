package pl.edu.pw.elka.bdbt.athleticsclub.model.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.model.worker.registration.WorkerService;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);
    private final WorkerRepository workerRepository;
    private WorkerService service;

    public WorkerController(WorkerRepository workerRepository, WorkerService service) {
        this.workerRepository = workerRepository;
        this.service = service;
    }



    @GetMapping("/db")
    ResponseEntity<List<Worker>> getAll() {
        LOGGER.info("Showing all the records in Workers entity!");
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping("/")
    public String register(Model model) {
        Worker worker = new Worker();
        model.addAttribute("worker", worker);
        return "register";
    }

    @PostMapping("/reg")
    public String registerWorker(@ModelAttribute("worker") Worker worker) {
        System.out.println(worker);
        service.registerWorker(worker);
        return "registerSuccess";
    }


}
