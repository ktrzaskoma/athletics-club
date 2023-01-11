package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility;

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

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/createSportFacility")
public class CreateSportFacilityController {

    private final SportFacilityRepository sportFacilityRepository;
    private final AthleticsClubRepository athleticsClubRepository;
    private final AddressRepository addressRepository;

    public CreateSportFacilityController(SportFacilityRepository sportFacilityRepository, AthleticsClubRepository athleticsClubRepository, AddressRepository addressRepository) {
        this.sportFacilityRepository = sportFacilityRepository;
        this.athleticsClubRepository = athleticsClubRepository;
        this.addressRepository = addressRepository;
    }

    @PostMapping("create")
    String createSportFacility(@ModelAttribute("sportFacility") @Valid SportFacilityWriteModel sportFacilityWriteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/createSportFacility";
        }
        var club = athleticsClubRepository.getById(sportFacilityWriteModel.getAthleticsClubFacility());
        var address = addressRepository.getById(sportFacilityWriteModel.getFacilityAddress());
        sportFacilityRepository.save(SportFacilityWriteModel.toEntity(sportFacilityWriteModel, club, address));
        return "redirect:/createSportFacility";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        return "/createSportFacility";
    }


    private Model prepareEntryModel(Model model) {
        var clubs = athleticsClubRepository.findAll()
                .stream().map(AthleticsClubReadModel::toReadModel)
                .collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));

        var addresses = addressRepository.findAll().stream().map(
                AddressReadModel::toReadModel
        ).collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));

        model.addAttribute("clubs", clubs);
        model.addAttribute("addresses", addresses);
        model.addAttribute("sportFacility", new SportFacilityWriteModel());

        return model;
    }
}
