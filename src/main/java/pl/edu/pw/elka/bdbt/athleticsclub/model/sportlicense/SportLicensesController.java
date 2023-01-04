package pl.edu.pw.elka.bdbt.athleticsclub.model.sportlicense;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.model.sportfacility.SportFacilitiesController;

import java.util.List;

@Controller
@RequestMapping("/sportlicenses")
public class SportLicensesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportFacilitiesController.class);
    private final SportLicensesRepository sportLicensesRepository;

    public SportLicensesController(SportLicensesRepository sportLicensesRepository) {
        this.sportLicensesRepository = sportLicensesRepository;
    }

    @GetMapping
    ResponseEntity<List<SportLicenses>> getAll() {
        LOGGER.info("Showing all the records in SportLicenses entity!");
        return ResponseEntity.ok(sportLicensesRepository.findAll());
    }
}
