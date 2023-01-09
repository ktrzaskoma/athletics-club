package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.training.TrainingRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.training.TrainingWriteModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/createtraining")
public class CreateTrainingController {

    private final TrainingRepository trainingRepository;

    public CreateTrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @GetMapping
    public String viewMainPage(Model model) {
        model.addAttribute("training", new TrainingWriteModel());
        return "createtraining";
    }

    @PostMapping("/done")
    String createTraining(@ModelAttribute("training") @Valid
                          TrainingWriteModel training,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createtraining";
        }
        trainingRepository.save(TrainingWriteModel.toTraining(training));
        return "createtraining";
    }

}
