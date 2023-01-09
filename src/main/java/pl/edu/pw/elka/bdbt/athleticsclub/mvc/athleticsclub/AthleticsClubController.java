package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/club")
public class AthleticsClubController {

    private final AthleticsClubRepository athleticsClubRepository;

    public AthleticsClubController(final AthleticsClubRepository athleticsClubRepository) {
        this.athleticsClubRepository = athleticsClubRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var addressList = athleticsClubRepository.findAll()
                .stream().map(
                        AthleticsClubReadModel::toReadModel
                ).toList();
        model.addAttribute("clubs", addressList);
        return "/club";
    }

    @PostMapping("/create")
    String createClub(@ModelAttribute("club") AthleticsClubWriteModel clubToWrite) {
        athleticsClubRepository.save(AthleticsClubWriteModel.toAthleticsClub(clubToWrite));
        return "/club";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("club", new AthleticsClubWriteModel());
        return "/club";
    }

}
