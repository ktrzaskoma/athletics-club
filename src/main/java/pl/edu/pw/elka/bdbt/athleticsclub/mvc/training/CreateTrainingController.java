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
@RequestMapping("/createTraining")
public class CreateTrainingController {

    private final TrainingRepository trainingRepository;
    private final AthleticsClubRepository athleticsClubRepository;

    public CreateTrainingController(TrainingRepository trainingRepository, AthleticsClubRepository athleticsClubRepository) {
        this.trainingRepository = trainingRepository;
        this.athleticsClubRepository = athleticsClubRepository;
    }

    @PostMapping("create")
    String createTraining(@ModelAttribute("createTraining") @Valid TrainingWriteModel trainingWriteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/createTraining";
        }
        var club = athleticsClubRepository.getById(trainingWriteModel.getAthleticsClub());
        trainingRepository.save(TrainingWriteModel.toEntity(trainingWriteModel, club));
        return "redirect:/createTraining";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        return "/createTraining";
    }


    private Model prepareEntryModel(Model model) {
        var clubs = athleticsClubRepository.findAll()
                .stream().map(AthleticsClubReadModel::toReadModel)
                .collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));
        model.addAttribute("clubs", clubs);
        model.addAttribute("createTraining", new TrainingWriteModel());

        return model;
    }
}
