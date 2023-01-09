package pl.edu.pw.elka.bdbt.athleticsclub.mvc.creation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerWriteModel;

@Controller
@RequestMapping("/createworker")
public class CreateWorkerController {

    private final WorkerRepository workerRepository;

    public CreateWorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping
    public String viewMainPage(Model model) {
        model.addAttribute("worker", new WorkerWriteModel());
        return "createworker";
    }

    @PostMapping("/worker")
    String createWorker(@ModelAttribute("worker") WorkerWriteModel worker) {
        workerRepository.save(WorkerWriteModel.toWorker(worker));
        return "createworker";
    }




}
