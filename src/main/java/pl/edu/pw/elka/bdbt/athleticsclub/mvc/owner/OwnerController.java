package pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owner")
@Log4j2
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var owners = ownerService.getOwners();
        prepareInitialModel(model, owners);
        return "/prodOwner";
    }

    private void prepareInitialModel(Model model, List<OwnerReadModel> readModelList) {
        model.addAttribute("owners", readModelList);
    }

    @PostMapping("/create")
    String createAddress(@ModelAttribute("owner") @Valid OwnerWriteModel writeModel,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodOwnerCreate" : validation;
        }
        ownerService.saveOwner(writeModel);
        return "redirect:/owner/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("owner", new OwnerWriteModel());
        var validation = prepareEntryModel(model);
        return validation.isEmpty() ? "/prodOwnerCreate" : validation;
    }

    @GetMapping("/delete/{idOwner}")
    String deleteAddress(@PathVariable("idOwner") String idOwner) {
        log.info("Try to delete entry!");
        ownerService.deleteOwner(idOwner);
        return "redirect:/owner/getAll";
    }

    @PostMapping("/edit/{idOwner}")
    String editOwner(@ModelAttribute("owner") @Valid OwnerWriteModel writeModel,
                     BindingResult bindingResult,
                     @PathVariable("idOwner") String idOwner,
                     Model model) {
        if (bindingResult.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            var addresses = ownerService.getAddresses();
            if (addresses.isEmpty()) {
                return "redirect:/address";
            }
            model.addAttribute("addresses", addresses);
            model.addAttribute("edit", true);
            return "/prodOwnerCreate";
        }
        writeModel.setNumber(Integer.valueOf(idOwner));
        ownerService.modifyOwner(writeModel);
        return "redirect:/owner/getAll";
    }

    @GetMapping("/edit/{idOwner}")
    String getOwnerToEdit(@PathVariable("idOwner") String idOwner, Model model) {
        log.info("Try to edit entry!");
        var editEntity = ownerService.editOwner(idOwner);
        model.addAttribute("owner", editEntity);
        var addresses = ownerService.getAddresses();
        if (addresses.isEmpty()) {
            return "redirect:/address";
        }
        model.addAttribute("addresses", addresses);
        model.addAttribute("edit", true);
        return "/prodOwnerCreate";
    }

    private String prepareEntryModel(Model model) {
        var addresses = ownerService.getAddresses();
        if (addresses.isEmpty()) {
            return "redirect:/address";
        }
        model.addAttribute("addresses", addresses);
        model.addAttribute("edit", false);
        return StringUtils.EMPTY;
    }
}
