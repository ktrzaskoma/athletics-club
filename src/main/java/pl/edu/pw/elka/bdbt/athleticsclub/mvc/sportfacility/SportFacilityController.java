package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sportfacility")
public class SportFacilityController {

    private final SportFacilityRepository sportFacilityRepository;

    public SportFacilityController(SportFacilityRepository sportFacilityRepository) {
        this.sportFacilityRepository = sportFacilityRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var sportFacilities = sportFacilityRepository.findAll()
                .stream().map(
                        SportFacilityReadModel::toReadModel
                ).toList();
        model.addAttribute("sportfacilities", sportFacilities);
        model.addAttribute("sportfacility", new SportFacilityWriteModel());
        return "/sportfacility";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("sportfacility", new SportFacilityWriteModel());
        return "/sportfacility";
    }
}
