package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        LOGGER.info("Showing all the records in Addresses entity!");
        var addressList = addressRepository.findAll()
                .stream().map(
                        AddressReadModel::toReadModel
                ).toList();
        model.addAttribute("addresses", addressList);
        return "/address";
    }

    @PostMapping("/create")
    String createAddress(@ModelAttribute("address") @Valid
                         AddressWriteModel addressWriteModel,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/address";
        }
        addressRepository.save(AddressWriteModel.toAddress(addressWriteModel));
        return "/address";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("address", new AddressWriteModel());
        return "/address";
    }


}
