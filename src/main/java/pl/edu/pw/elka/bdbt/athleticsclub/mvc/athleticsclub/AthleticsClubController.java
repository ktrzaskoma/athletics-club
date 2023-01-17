package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.OwnerWriteModel;

import javax.validation.Valid;
import java.util.List;

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
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            return "/prodClubCreate";
        }
        clubService.saveClub(writeModel);
        return "redirect:/club/getAll";
    }

    @PostMapping("/edit/{idClub}")
    String editClub(@ModelAttribute("club") @Valid AthleticsClubWriteModel writeModel,
                    BindingResult bindingResult,
                    @PathVariable("idClub") String idClub,
                    Model model) {
        if (bindingResult.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            prepareEntryModel(model);
            model.addAttribute("edit", true);
            return "/prodClubCreate";
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
        prepareEntryModel(model);
        return "/prodClubCreate";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("edit", false);
        model.addAttribute("club", new AthleticsClubWriteModel());
        return "/prodClubCreate";
    }

    private Model prepareEntryModel(Model model) {
        var addresses = clubService.getFormattedAddresses();
        var owners = clubService.getFormattedOwners();
        model.addAttribute("addresses", addresses);
        model.addAttribute("owners", owners);
        return model;
    }

    @GetMapping("/delete/{idClub}")
    String deleteAddress(@PathVariable("idClub") String idClub) {
        log.info("Try to delete entry!");
        clubService.deleteClub(idClub);
        return "redirect:/club/getAll";
    }
}
