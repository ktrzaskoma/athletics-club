package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/address")
@Log4j2
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var addresses = addressService.getAddresses();
        prepareInitialModel(model, addresses);
        return "prodAddress";
    }

    @PostMapping("/create")
    String createAddress(@ModelAttribute("address") @Valid AddressWriteModel addressWriteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            return "/prodAddressCreate";
        }
        addressService.saveAddress(addressWriteModel);
        return "redirect:/address/getAll";
    }

    @PostMapping("/edit/{idAddress}")
    String saveAddress(@ModelAttribute("address") @Valid AddressWriteModel addressWriteModel,
                       BindingResult bindingResult,
                       @PathVariable("idAddress") String idAddress) {
        if (bindingResult.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            return "/prodAddressCreate";
        }
        addressWriteModel.setAddressNumber(idAddress);
        addressService.saveAddress(addressWriteModel);
        return "redirect:/address/getAll";
    }

    @GetMapping("/delete/{idAddress}")
    String deleteAddress(@PathVariable("idAddress") String idAddress) {
        log.info("Try to delete entry!");
        addressService.deleteAddress(idAddress);
        return "redirect:/address/getAll";
    }

    @GetMapping("/edit/{idAddress}")
    String getAddressToEdit(@PathVariable("idAddress") String idAddress, Model model) {
        log.info("Try to edit entry!");
        var editEntity = addressService.editAddress(idAddress);
        model.addAttribute("address", editEntity);
        model.addAttribute("edit", true);
        return "/prodAddressCreate";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareInitialModel(model, Collections.EMPTY_LIST);
        return "/prodAddressCreate";
    }

    private void prepareInitialModel(Model model, List<AddressReadModel> readModelList) {
        model.addAttribute("address", new AddressWriteModel());
        model.addAttribute("addresses", readModelList);
        model.addAttribute("edit", false);
    }


}
