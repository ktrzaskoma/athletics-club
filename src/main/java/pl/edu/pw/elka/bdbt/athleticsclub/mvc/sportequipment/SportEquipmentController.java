package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer.EquipmentProducerReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer.EquipmentProducerRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.FacilityReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.FacilityRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/equipment")
public class SportEquipmentController {

    private final SportEquipmentRepository sportEquipmentRepository;
    private final EquipmentProducerRepository equipmentProducerRepository;
    private final AthleticsClubRepository athleticsClubRepository;
    private final FacilityRepository facilityRepository;

    public SportEquipmentController(SportEquipmentRepository sportEquipmentRepository,
                                    EquipmentProducerRepository equipmentProducerRepository,
                                    AthleticsClubRepository athleticsClubRepository,
                                    FacilityRepository facilityRepository) {
        this.sportEquipmentRepository = sportEquipmentRepository;
        this.equipmentProducerRepository = equipmentProducerRepository;
        this.athleticsClubRepository = athleticsClubRepository;
        this.facilityRepository = facilityRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var equipments = sportEquipmentRepository.findAll()
                .stream().map(
                        SportEquipmentReadModel::toReadModel
                ).toList();
        model.addAttribute("equipments", equipments);
        model.addAttribute("equipment", new SportEquipmentWriteModel());
        prepareEntryModel(model);
        return "/equipment";
    }

    @PostMapping("/create")
    String createLicense(@ModelAttribute("equipment") @Valid
                         SportEquipmentWriteModel writeModel,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            return "/equipment";
        }
        var club = athleticsClubRepository.getById(writeModel.getAthleticsClubEquipment());
        var facility = facilityRepository.getById(writeModel.getEquipmentStorage());
        var producer = equipmentProducerRepository.getById(writeModel.getEquipmentProducer());
        sportEquipmentRepository.save(SportEquipmentWriteModel.toEntity(writeModel, club, facility, producer));
        return "redirect:/equipment";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("equipment", new SportEquipmentWriteModel());
        return "/equipment";
    }
    private Model prepareEntryModel(Model model) {
        var producers = equipmentProducerRepository.findAll()
                .stream().map(EquipmentProducerReadModel::toReadModel)
                .collect(Collectors.toMap(EquipmentProducerReadModel::getNumber, EquipmentProducerReadModel::toString));

        var clubs = athleticsClubRepository.findAll()
                .stream().map(AthleticsClubReadModel::toReadModel)
                .collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));

        var facilities = facilityRepository.findAll()
                .stream().map(FacilityReadModel::toReadModel)
                .collect(Collectors.toMap(FacilityReadModel::getNumber, FacilityReadModel::toString));


        model.addAttribute("producers", producers);
        model.addAttribute("clubs", clubs);
        model.addAttribute("facilities", facilities);
        return model;
    }

}
