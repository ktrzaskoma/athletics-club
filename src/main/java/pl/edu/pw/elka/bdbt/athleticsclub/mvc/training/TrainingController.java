package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/training")
public class TrainingController {

    private final TrainingRepository trainingRepository;
    private final AthleticsClubRepository athleticsClubRepository;

    public TrainingController(TrainingRepository trainingRepository, AthleticsClubRepository athleticsClubRepository) {
        this.trainingRepository = trainingRepository;
        this.athleticsClubRepository = athleticsClubRepository;
    }


    @GetMapping("getAll")
    String getAll(Model model) {
        var trainings = trainingRepository.findAll()
                .stream().map(
                        TrainingReadModel::toReadModel
                ).toList();
        model.addAttribute("trainings", trainings);
        model.addAttribute("training", new TrainingWriteModel());
        prepareEntryModel(model);
        return "/training";
    }

    @PostMapping("create")
    String createTraining(@ModelAttribute("training") @Valid TrainingWriteModel trainingWriteModel,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            return "/training";
        }
        var club = athleticsClubRepository.getById(trainingWriteModel.getAthleticsClub());
        trainingRepository.save(TrainingWriteModel.toEntity(trainingWriteModel, club));
        return "redirect:/training";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("training", new TrainingWriteModel());
        return "/training";
    }

    private Model prepareEntryModel(Model model) {
        var clubs = athleticsClubRepository.findAll().stream().map(
                        AthleticsClubReadModel::toReadModel
                ).collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));
        model.addAttribute("clubs", clubs);
        return model;
    }
}
