package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/training")
public class TrainingController {

    private final TrainingRepository trainingRepository;
    private final AthleticsClubRepository athleticsClubRepository;
    private final WorkerRepository workerRepository;

    public TrainingController(TrainingRepository trainingRepository, AthleticsClubRepository athleticsClubRepository, WorkerRepository workerRepository) {
        this.trainingRepository = trainingRepository;
        this.athleticsClubRepository = athleticsClubRepository;
        this.workerRepository = workerRepository;
    }


    // Training sign up area
    @GetMapping("signup")
    String signUpForTraining(Model model) {
        var trainings = trainingRepository.findAll()
                .stream().map(
                        TrainingReadModel::toReadModel
                ).toList();
        model.addAttribute("trainings", trainings);
        model.addAttribute("training", new TrainingWriteModel());
        prepareEntryModel(model);
        return "/trainingSign";
    }

    @PostMapping("signup/{idTraining}")
    String saveTraining(@RequestParam("idAthlete") String idAthlete, @PathVariable String idTraining) {
        var athlete = workerRepository.getById(Integer.valueOf(idAthlete));
        var training = trainingRepository.getById(Integer.valueOf(idTraining));
        var athletes = training.getWorkers();
        athletes.add(athlete);
        training.setWorkers(athletes);
        trainingRepository.save(training);
        return "redirect:/training/signup";
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

        var workers = workerRepository.findAll().stream().map(
                WorkerReadModel::toReadModel
        ).collect(Collectors.toMap(WorkerReadModel::getNumber, WorkerReadModel::toString));

        model.addAttribute("clubs", clubs);
        model.addAttribute("workers", workers);
        return model;
    }
}
