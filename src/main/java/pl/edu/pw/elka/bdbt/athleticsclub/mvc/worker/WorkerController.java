package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicenseRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicenseWriteModel;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerRepository workerRepository;
    private final AthleticsClubRepository athleticsClubRepository;
    private final AddressRepository addressRepository;
    private final SportLicenseRepository sportLicenseRepository;


    public WorkerController(WorkerRepository workerRepository, AthleticsClubRepository athleticsClubRepository, AddressRepository addressRepository, SportLicenseRepository sportLicenseRepository) {
        this.workerRepository = workerRepository;
        this.athleticsClubRepository = athleticsClubRepository;
        this.addressRepository = addressRepository;
        this.sportLicenseRepository = sportLicenseRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var workers = workerRepository.findAll()
                .stream().map(
                        WorkerReadModel::toReadModel
                ).toList();
        model.addAttribute("workers", workers);
        model.addAttribute("worker", new WorkerWriteModel());
        model.addAttribute("licence", new SportLicenseWriteModel());
        prepareEntryModel(model);
        return "/worker";
    }

    @PostMapping("/create")
    String createWorker(@ModelAttribute("worker") @Valid
                        WorkerWriteModel workerWriteModel,
                        @ModelAttribute("licence") @Valid
                        SportLicenseWriteModel sportLicenseWriteModel,
                        BindingResult bindingResult,
                        Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            return "/worker";
        }

        var club = athleticsClubRepository.getById(workerWriteModel.getAthleticsClubWorker());
        var address = addressRepository.getById(workerWriteModel.getWorkerAddressNumber());

        var savedLicense = sportLicenseRepository.save(SportLicenseWriteModel.toEntity(
                sportLicenseWriteModel
        ));

        workerRepository.save(WorkerWriteModel.toEntity(workerWriteModel, club, savedLicense, address));

        return "redirect:/worker";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("worker", new WorkerWriteModel());
        model.addAttribute("licence", new SportLicenseWriteModel());
        return "/worker";
    }

    private Model prepareEntryModel(Model model) {

        var addresses = addressRepository.findAll().stream().map(
                AddressReadModel::toReadModel
        ).collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));

        var clubs = athleticsClubRepository.findAll().stream().map(
                AthleticsClubReadModel::toReadModel
        ).collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));

        model.addAttribute("addresses", addresses);
        model.addAttribute("clubs", clubs);
        return model;
    }


}
