package pl.edu.pw.elka.bdbt.athleticsclub.mvc.creation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility.SportFacilityRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility.SportFacilityWriteModel;

@Controller
@RequestMapping("/createfacility")
public class CreateSportFacilityController {

    private final SportFacilityRepository sportFacilityRepository;

    public CreateSportFacilityController(SportFacilityRepository sportFacilityRepository) {
        this.sportFacilityRepository = sportFacilityRepository;
    }

    @GetMapping
    public String viewMainPage(Model model) {
        model.addAttribute("sportFacility", new SportFacilityWriteModel());
        return "createsportfacility";
    }

    @PostMapping("/facility")
    String createSportFacility(@ModelAttribute("sportFacility") SportFacilityWriteModel sportFacility) {
        sportFacilityRepository.save(SportFacilityWriteModel.toSportFacility(sportFacility));
        return "createsportfacility";
    }

}
