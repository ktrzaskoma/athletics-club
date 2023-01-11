package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressWriteModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/training")
public class TrainingController {

    private final TrainingRepository trainingRepository;

    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }


    @GetMapping("getAll")
    String getAll(Model model) {
        var trainings = trainingRepository.findAll()
                .stream().map(
                        TrainingReadModel::toReadModel
                ).toList();
        model.addAttribute("trainings", trainings);
        model.addAttribute("training", new TrainingWriteModel());
        return "/training";
    }

    @PostMapping("create")
    String createTraining(@ModelAttribute("training") @Valid TrainingWriteModel trainingWriteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/training";
        }
        trainingRepository.save(TrainingWriteModel.toEntity(trainingWriteModel));
        return "redirect:/training";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("training", new TrainingWriteModel());
        return "/training";
    }



}
