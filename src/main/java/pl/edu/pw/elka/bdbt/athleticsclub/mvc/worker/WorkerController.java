package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicenseWriteModel;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

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
            model.addAttribute("edit", false);
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodWorkerCreate" : validation;
        }
        workerService.saveWorker(workerWriteModel, sportLicenseWriteModel);
        return "redirect:/worker/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("edit", false);
        model.addAttribute("worker", new WorkerWriteModel());
        model.addAttribute("license", new SportLicenseWriteModel());
        var validation = prepareEntryModel(model);
        return validation.isEmpty() ? "/prodWorkerCreate" : validation;
    }

    @GetMapping("/delete/{idWorker}")
    String deleteAddress(@PathVariable("idWorker") String idWorker) {
        log.info("Try to delete entry!");
        workerService.deleteWorker(idWorker);
        return "redirect:/worker/getAll";
    }

    @PostMapping("/edit/{idWorker}")
    String editWorker(@ModelAttribute("worker") @Valid
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
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodWorkerCreate" : validation;
        }
        workerWriteModel.setNumber(Integer.valueOf(idWorker));
        workerService.modifyWorker(workerWriteModel, sportLicenseWriteModel);

        return "redirect:/worker/getAll";
    }

    @GetMapping("/edit/{idWorker}")
    String getAddressToEdit(@PathVariable("idWorker") String idWorker, Model model) {
        log.info("Try to edit entry!");
        var validation = prepareEntryModel(model);
        if (validation.isEmpty()) {
            var editWorker = workerService.editWorker(idWorker);
            model.addAttribute("worker", editWorker);
            var editLicense = workerService.editLicense(editWorker.getSportLicense().getSportLicenseNumber().toString());
            model.addAttribute("license", editLicense);
            model.addAttribute("edit", true);
        }
        return validation.isEmpty() ? "/prodWorkerCreate" : validation;
    }


    private String prepareEntryModel(Model model) {
        var addresses = workerService.getFormattedAddresses();
        if (addresses.isEmpty()) {
            return "redirect:/address";
        }
        var clubs = workerService.getFormattedClubs();
        if (clubs.isEmpty()) {
            return "redirect:/club";
        }
        model.addAttribute("addresses", addresses);
        model.addAttribute("clubs", clubs);
        return StringUtils.EMPTY;
    }


}
