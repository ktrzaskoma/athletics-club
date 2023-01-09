package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/license")
public class SportLicenseController {

    private final SportLicenseRepository sportLicenseRepository;

    public SportLicenseController(SportLicenseRepository sportLicenseRepository) {
        this.sportLicenseRepository = sportLicenseRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var licenses = sportLicenseRepository.findAll()
                .stream().map(
                        SportLicenseReadModel::toReadModel
                ).toList();
        model.addAttribute("licenses", licenses);
        return "/license";
    }

    @PostMapping("/create")
    String createLicense(@ModelAttribute("license") @Valid
                         SportLicenseWriteModel licenseWriteModel,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/license";
        }
        sportLicenseRepository.save(SportLicenseWriteModel.toSportLicense(licenseWriteModel));
        return "/license";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("license", new SportLicenseWriteModel());
        return "/license";
    }
}
