package pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubWriteModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/facility")
@Log4j2
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        prepareInitialModel(model);
        return "/prodFacility";
    }

    private void prepareInitialModel(Model model) {
        var facilities = facilityService.getSportFacilities();
        model.addAttribute("facilities", facilities);
    }

    @PostMapping("create")
    String createFacility(@ModelAttribute("facility") @Valid FacilityWriteModel writeModel,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            model.addAttribute("edit", false);
            return "/prodFacilityCreate";
        }
        facilityService.saveFacility(writeModel);
        return "redirect:/facility/getAll";
    }

    @PostMapping("/edit/{idFacility}")
    String editFacility(@ModelAttribute("facility") @Valid FacilityWriteModel writeModel,
                        BindingResult bindingResult,
                        @PathVariable("idFacility") String idFacility,
                        Model model) {
        if (bindingResult.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            prepareEntryModel(model);
            model.addAttribute("edit", true);
            return "/prodFacilityCreate";
        }
        writeModel.setNumber(Integer.valueOf(idFacility));
        facilityService.modifyFacility(writeModel);
        return "redirect:/facility/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("facility", new FacilityWriteModel());
        model.addAttribute("edit", false);
        return "/prodFacilityCreate";
    }

    @GetMapping("/delete/{idFacility}")
    String deleteFacility(@PathVariable("idFacility") String idFacility) {
        log.info("Try to delete entry!");
        facilityService.deleteFacility(idFacility);
        return "redirect:/facility/getAll";
    }

    @GetMapping("/edit/{idFacility}")
    String getFacilityToEdit(@PathVariable("idFacility") String idFacility, Model model) {
        log.info("Try to edit entry!");
        var editEntity = facilityService.editFacility(idFacility);
        model.addAttribute("facility", editEntity);
        model.addAttribute("edit", true);
        prepareEntryModel(model);
        return "/prodFacilityCreate";
    }

    private Model prepareEntryModel(Model model) {
        var clubs = facilityService.getFormattedClubs();
        var addresses = facilityService.getFormattedAddresses();
        model.addAttribute("clubs", clubs);
        model.addAttribute("addresses", addresses);
        return model;
    }

}
