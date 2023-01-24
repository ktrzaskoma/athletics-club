package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/training")
@Log4j2
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("sign/{idTraining}")
    String signUpForTraining(@PathVariable String idTraining, Model model) {
        var training = trainingService.getTrainingById(idTraining);
        var workers = trainingService.getFormattedWorkersAvailableForTraining(idTraining);
        model.addAttribute("training", training);
        model.addAttribute("workers", workers);
        return "/prodTrainingSign";
    }

    @PostMapping("sign/{idTraining}")
    String addAtheleteToTraining(@RequestParam("idAthlete") String idAthlete, @PathVariable String idTraining) {
        trainingService.addAthleteToTraining(idAthlete, idTraining);
        return "redirect:/training/getAll";
    }

    @GetMapping("getAll")
    String getAll(Model model) {
        var trainings = trainingService.getTrainings();
        model.addAttribute("trainings", trainings);
        return "/prodTraining";
    }

    @PostMapping("create")
    String createTraining(@ModelAttribute("training") @Valid TrainingWriteModel writeModel,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            model.addAttribute("edit", false);
            return "/prodTrainingCreate";
        }
        trainingService.saveTraining(writeModel);
        return "redirect:/training/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("training", new TrainingWriteModel());
        model.addAttribute("edit", false);
        return "/prodTrainingCreate";
    }

    @PostMapping("/edit/{idTraining}")
    String editAddress(@ModelAttribute("training") @Valid TrainingWriteModel writeModel,
                       BindingResult bindingResult,
                       @PathVariable("idTraining") String idTraining,
                       Model model) {
        if (bindingResult.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            model.addAttribute("edit", true);
            return "/prodTrainingCreate";
        }
        writeModel.setNumber(Integer.valueOf(idTraining));
        trainingService.modifyTraining(writeModel);
        return "redirect:/training/getAll";
    }

    @GetMapping("/delete/{idTraining}")
    String deleteTraining(@PathVariable("idTraining") String idTraining) {
        log.info("Try to delete entry!");
        trainingService.deleteTraining(idTraining);
        return "redirect:/training/getAll";
    }

    @GetMapping("/edit/{idTraining}")
    String getTrainingToEdit(@PathVariable("idTraining") String idTraining, Model model) {
        log.info("Try to edit entry!");
        var editEntry = trainingService.editTraining(idTraining);
        model.addAttribute("training", editEntry);
        prepareEntryModel(model);
        model.addAttribute("edit", true);
        return "/prodTrainingCreate";
    }

    private Model prepareEntryModel(Model model) {
        var clubs = trainingService.getFormattedClubs();
        var workers = trainingService.getFormattedWorkers();
        model.addAttribute("clubs", clubs);
        model.addAttribute("workers", workers);
        return model;
    }
}
