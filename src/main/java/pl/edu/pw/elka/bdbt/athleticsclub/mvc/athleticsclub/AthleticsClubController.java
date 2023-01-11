package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.OwnerReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.OwnerRepository;

import javax.validation.Valid;
import java.util.Collections;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/club")
public class AthleticsClubController {

    private final AthleticsClubRepository athleticsClubRepository;
    private final AddressRepository addressRepository;
    private final OwnerRepository ownerRepository;

    public AthleticsClubController(final AthleticsClubRepository athleticsClubRepository, AddressRepository addressRepository, OwnerRepository ownerRepository) {
        this.athleticsClubRepository = athleticsClubRepository;
        this.addressRepository = addressRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var athleticsClubList = athleticsClubRepository.findAll()
                .stream().map(
                        AthleticsClubReadModel::toReadModel
                ).toList();
        model.addAttribute("clubs", athleticsClubList);
        model.addAttribute("club", new AthleticsClubWriteModel());
        prepareEntryModel(model);
        return "/club";
    }

    @PostMapping("/create")
    String createClub(@ModelAttribute("club") @Valid AthleticsClubWriteModel clubToWrite,
                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            return "/club";
        }

        var address = addressRepository.getById(clubToWrite.getAddressNumber());
        var owner = ownerRepository.getById(clubToWrite.getOwnerOfAthleticsClub());
        athleticsClubRepository.save(AthleticsClubWriteModel.toEntity(clubToWrite, address, owner));

        return "redirect:/club";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("club", new AthleticsClubWriteModel());
        return "/club";
    }


    private Model prepareEntryModel(Model model) {
        var addresses = addressRepository.findAll().stream().map(
                AddressReadModel::toReadModel
        ).collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));

        var owners = ownerRepository.findAll().stream().map(
                OwnerReadModel::toReadModel
        ).collect(Collectors.toMap(OwnerReadModel::getOwnerNumber, OwnerReadModel::toString));

        model.addAttribute("addresses", addresses);
        model.addAttribute("owners", owners);
        return model;
    }
}
