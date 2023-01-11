package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerRepository workerRepository;

    public WorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var workers = workerRepository.findAll()
                .stream().map(
                        WorkerReadModel::toReadModel
                ).toList();
        model.addAttribute("workers", workers);
        model.addAttribute("worker", new WorkerWriteModel());
        return "/worker";
    }

    @GetMapping("/sortbysalary")
    String sortBySalary(Model model) {
        var workersBySalary = workerRepository.findAllByOrderByWorkerSalaryAsc()
                .stream().map(
                        WorkerReadModel::toReadModel
                ).toList();
        model.addAttribute("workers", workersBySalary);
        model.addAttribute("worker", new WorkerWriteModel());
        return "/worker";
    }

    @PostMapping("/create")
    String createWorker(@ModelAttribute("worker") @Valid WorkerWriteModel workerWriteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/worker";
        }
        workerRepository.save(WorkerWriteModel.toEntity(workerWriteModel));
        return "redirect:/worker";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("worker", new WorkerWriteModel());
        return "/worker";
    }


}
