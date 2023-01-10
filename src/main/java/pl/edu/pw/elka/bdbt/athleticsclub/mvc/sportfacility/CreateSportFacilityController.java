package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    String createSportFacility(@ModelAttribute("sportFacility") @Valid
                               SportFacilityWriteModel sportFacility,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createsportfacility";
        }
        sportFacilityRepository.save(SportFacilityWriteModel.toEntity(sportFacility));
        return "createsportfacility";
    }

}
