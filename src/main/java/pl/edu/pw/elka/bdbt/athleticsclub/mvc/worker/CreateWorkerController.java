package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerWriteModel;

import javax.validation.Valid;

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
    String createWorker(@ModelAttribute("worker") @Valid WorkerWriteModel worker,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createworker";
        }
        workerRepository.save(WorkerWriteModel.toWorker(worker));
        return "createworker";
    }




}
