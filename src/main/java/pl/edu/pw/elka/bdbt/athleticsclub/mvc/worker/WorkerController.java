package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.salary.SalaryRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerRepository workerRepository;
    private final AthleticsClubRepository athleticsClubRepository;
    private final AddressRepository addressRepository;
    private final SalaryRepository salaryRepository;

    public WorkerController(WorkerRepository workerRepository, AthleticsClubRepository athleticsClubRepository, AddressRepository addressRepository, SalaryRepository salaryRepository) {
        this.workerRepository = workerRepository;
        this.athleticsClubRepository = athleticsClubRepository;
        this.addressRepository = addressRepository;
        this.salaryRepository = salaryRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var workers = workerRepository.findAll()
                .stream().map(
                        WorkerReadModel::toReadModel
                ).toList();
        model.addAttribute("workers", workers);
        model.addAttribute("worker", new WorkerWriteModel());
        prepareEntryModel(model);
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
        prepareEntryModel(model);
        return "/worker";
    }

    @PostMapping("/create")
    String createWorker(@ModelAttribute("worker") @Valid
                        WorkerWriteModel workerWriteModel,
                        BindingResult bindingResult,
                        Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            return "/worker";
        }
        var club = athleticsClubRepository.getById(workerWriteModel.getAthleticsClubWorker());
        var address = addressRepository.getById(workerWriteModel.getWorkerAddressNumber());
        workerRepository.save(WorkerWriteModel.toEntity(workerWriteModel, club, address));
        return "redirect:/worker";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("worker", new WorkerWriteModel());
        return "/worker";
    }

    private Model prepareEntryModel(Model model) {
        var addresses = addressRepository.findAll().stream().map(
                AddressReadModel::toReadModel
        ).collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));

        var clubs = athleticsClubRepository.findAll().stream().map(
                AthleticsClubReadModel::toReadModel
        ).collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));

//        var salaries = salaryRepository.findAll().stream().map(
//                AthleticsClubReadModel::toReadModel
//        ).collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));


        model.addAttribute("addresses", addresses);
        model.addAttribute("clubs", clubs);
        return model;
    }


}
