package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressWriteModel;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/club")
public class AthleticsClubController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AthleticsClubController.class);
    private final AthleticsClubRepository athleticsClubRepository;

    public AthleticsClubController(final AthleticsClubRepository athleticsClubRepository) {
        this.athleticsClubRepository = athleticsClubRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        LOGGER.info("Showing all the records in Addresses entity!");
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
