package pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerRepository ownerRepository;
    private final AddressRepository addressRepository;

    public OwnerController(OwnerRepository ownerRepository, AddressRepository addressRepository) {
        this.ownerRepository = ownerRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var owners = ownerRepository.findAll()
                .stream().map(
                        OwnerReadModel::toReadModel
                ).toList();
        model.addAttribute("owners", owners);
        model.addAttribute("owner", new OwnerWriteModel());
        return "/owner";
    }

    @PostMapping("/create")
    String createAddress(@ModelAttribute("owner") @Valid OwnerWriteModel writeModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/owner";
        }
        var entity = addressRepository.getById(writeModel.getAddressNumber());
        ownerRepository.save(OwnerWriteModel.toEntity(writeModel, entity));
        return "redirect:/owner";
    }

    @GetMapping
    String viewPage(Model model) {
        var addresses = addressRepository.findAll().stream().map(
                AddressReadModel::toReadModel
        ).collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));

        model.addAttribute("owner", new OwnerWriteModel());
        model.addAttribute("addresses", addresses);

        return "/owner";
    }
}
