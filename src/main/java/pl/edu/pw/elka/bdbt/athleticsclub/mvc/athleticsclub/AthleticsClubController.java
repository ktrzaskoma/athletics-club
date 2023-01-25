package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/club")
@Log4j2
public class AthleticsClubController {

    private final AthleticsClubService clubService;

    public AthleticsClubController(AthleticsClubService athleticsClubRepository) {
        this.clubService = athleticsClubRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var athleticsClubList = clubService.getClubs();
        prepareInitialModel(model, athleticsClubList);
        return "/prodClub";
    }

    private void prepareInitialModel(Model model, List<AthleticsClubReadModel> readModelList) {
        model.addAttribute("clubs", readModelList);
    }

    @PostMapping("/create")
    String createClub(@ModelAttribute("club") @Valid AthleticsClubWriteModel writeModel,
                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() || Objects.isNull(writeModel.getAddressNumber()) || Objects.isNull(writeModel.getOwnerOfAthleticsClub())) {
            model.addAttribute("edit", false);
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodClubCreate" : validation;
        }
        clubService.saveClub(writeModel);
        return "redirect:/club/getAll";
    }

    @PostMapping("/edit/{idClub}")
    String editClub(@ModelAttribute("club") @Valid AthleticsClubWriteModel writeModel,
                    BindingResult bindingResult,
                    @PathVariable("idClub") String idClub,
                    Model model) {
        if (bindingResult.hasErrors() || Objects.isNull(writeModel.getAddressNumber()) || Objects.isNull(writeModel.getOwnerOfAthleticsClub())) {
            log.warn("Errors founds, try to show them in view!");
            model.addAttribute("edit", true);
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodClubCreate" : validation;
        }
        writeModel.setNumber(Integer.valueOf(idClub));
        clubService.modifyClub(writeModel);
        return "redirect:/club/getAll";
    }

    @GetMapping("/edit/{idClub}")
    String getClubToEdit(@PathVariable("idClub") String idClub, Model model) {
        log.info("Try to edit entry!");
        var editEntity = clubService.editClub(idClub);
        model.addAttribute("club", editEntity);
        model.addAttribute("edit", true);
        var validation = prepareEntryModel(model);
        return validation.isEmpty() ? "/prodClubCreate" : validation;
    }

    @GetMapping
    String viewPage(Model model) {
        var validation = prepareEntryModel(model);
        model.addAttribute("edit", false);
        model.addAttribute("club", new AthleticsClubWriteModel());
        return validation.isEmpty() ? "/prodClubCreate" : validation;
    }

    private String prepareEntryModel(Model model) {
        var addresses = clubService.getFormattedAddresses();
        if (addresses.isEmpty()) {
            return "redirect:/address";
        }
        var owners = clubService.getFormattedOwners();
        if (owners.isEmpty()) {
            return "redirect:/owner";
        }
        model.addAttribute("addresses", addresses);
        model.addAttribute("owners", owners);
        model.addAttribute("maxDate", LocalDate.now().toString());
        return StringUtils.EMPTY;
    }

    @GetMapping("/delete/{idClub}")
    String deleteAddress(@PathVariable("idClub") String idClub) {
        log.info("Try to delete entry!");
        clubService.deleteClub(idClub);
        return "redirect:/club/getAll";
    }
}
