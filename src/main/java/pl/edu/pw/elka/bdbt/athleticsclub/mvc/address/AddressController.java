package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/address")
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var addressList = addressRepository.findAll()
                .stream().map(
                        AddressReadModel::toReadModel
                ).toList();
        model.addAttribute("addresses", addressList);
        model.addAttribute("address", new AddressWriteModel());
        return "prodAddress";
    }

    @PostMapping("/create")
    String createAddress(@ModelAttribute("address") @Valid AddressWriteModel addressWriteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/prodAddressCreate";
        }
        addressRepository.save(AddressWriteModel.toEntity(addressWriteModel));
        return "redirect:/address";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("address", new AddressWriteModel());
        return "/prodAddressCreate";
    }


}
