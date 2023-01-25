package pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubWriteModel;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Objects;

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
        if (bindingResult.hasErrors() || Objects.isNull(writeModel.getFacilityAddress()) || Objects.isNull(writeModel.getAthleticsClubFacility())) {
            model.addAttribute("edit", false);
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodFacilityCreate" : validation;
        }
        facilityService.saveFacility(writeModel);
        return "redirect:/facility/getAll";
    }

    @PostMapping("/edit/{idFacility}")
    String editFacility(@ModelAttribute("facility") @Valid FacilityWriteModel writeModel,
                        BindingResult bindingResult,
                        @PathVariable("idFacility") String idFacility,
                        Model model) {
        if (bindingResult.hasErrors() || Objects.isNull(writeModel.getFacilityAddress()) || Objects.isNull(writeModel.getAthleticsClubFacility()))
        {
            log.warn("Errors founds, try to show them in view!");
            model.addAttribute("edit", true);
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodFacilityCreate" : validation;
        }
        writeModel.setNumber(Integer.valueOf(idFacility));
        facilityService.modifyFacility(writeModel);
        return "redirect:/facility/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("facility", new FacilityWriteModel());
        model.addAttribute("edit", false);
        var validation = prepareEntryModel(model);
        return validation.isEmpty() ? "/prodFacilityCreate" : validation;
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
        var validation = prepareEntryModel(model);
        return validation.isEmpty() ? "/prodFacilityCreate" : validation;
    }

    private String prepareEntryModel(Model model) {
        var clubs = facilityService.getFormattedClubs();
        var addresses = facilityService.getFormattedAddresses();
        if (clubs.isEmpty()) {
            return "redirect:/club";
        }
        if (addresses.isEmpty()) {
            return "redirect:/address";
        }
        model.addAttribute("clubs", clubs);
        model.addAttribute("addresses", addresses);
        model.addAttribute("maxDate", LocalDate.now().toString());
        return StringUtils.EMPTY;
    }

}
