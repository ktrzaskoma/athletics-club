package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicenseWriteModel;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/worker")
@Log4j2
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var workers = workerService.getWorkers();
        prepareInitialModel(model, workers);
        return "/prodWorker";
    }

    private void prepareInitialModel(Model model, List<WorkerReadModel> readModelList) {
        model.addAttribute("workers", readModelList);
        model.addAttribute("edit", false);
    }

    @PostMapping("/create")
    String createWorker(@ModelAttribute("worker") @Valid
                                WorkerWriteModel workerWriteModel,
                        BindingResult bindingResultWorker,
                        @ModelAttribute("license") @Valid
                                SportLicenseWriteModel sportLicenseWriteModel,
                        BindingResult bindingResultLicense,
                        Model model) {
        if (bindingResultWorker.hasErrors() || bindingResultLicense.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            prepareEntryModel(model);
            return "/prodWorkerCreate";
        }
        workerService.saveWorker(workerWriteModel, sportLicenseWriteModel);
        return "redirect:/worker/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("worker", new WorkerWriteModel());
        model.addAttribute("license", new SportLicenseWriteModel());
        return "/prodWorkerCreate";
    }

    @GetMapping("/delete/{idWorker}")
    String deleteAddress(@PathVariable("idWorker") String idWorker) {
        log.info("Try to delete entry!");
        workerService.deleteWorker(idWorker);
        return "redirect:/worker/getAll";
    }

    @PostMapping("/edit/{idWorker}")
    String saveAddress(@ModelAttribute("worker") @Valid
                               WorkerWriteModel workerWriteModel,
                       BindingResult bindingResultWorker,
                       @ModelAttribute("license") @Valid
                               SportLicenseWriteModel sportLicenseWriteModel,
                       BindingResult bindingResultLicense,
                       @PathVariable("idWorker") String idWorker,
                       Model model) {
        if (bindingResultWorker.hasErrors() || bindingResultLicense.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            model.addAttribute("edit", true);
            return "/prodAddressCreate";
        }
        workerService.saveWorker(workerWriteModel, sportLicenseWriteModel);

        return "redirect:/address/getAll";
    }

    @GetMapping("/edit/{idWorker}")
    String getAddressToEdit(@PathVariable("idWorker") String idWorker, Model model) {
        log.info("Try to edit entry!");
        var editWorker = workerService.editWorker(idWorker);
        model.addAttribute("worker", editWorker);
        var editLicense = workerService.editLicense(editWorker.getSportLicense().getSportLicenseNumber().toString());
        model.addAttribute("license", editLicense);
        model.addAttribute("edit", true);
        return "/prodAddressCreate";
    }


    private Model prepareEntryModel(Model model) {
        var addresses = workerService.getFormattedAddresses();
        var clubs = workerService.getFormattedClubs();

        model.addAttribute("addresses", addresses);
        model.addAttribute("clubs", clubs);
        model.addAttribute("edit", false);
        return model;
    }


}
