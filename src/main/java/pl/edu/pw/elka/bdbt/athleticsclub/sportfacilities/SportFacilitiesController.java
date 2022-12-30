package pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sportfacilities")
public class SportFacilitiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportFacilitiesController.class);
    private final SportFacilitiesRepository sportFacilitiesRepository;

    public SportFacilitiesController(SportFacilitiesRepository sportFacilitiesRepository) {
        this.sportFacilitiesRepository = sportFacilitiesRepository;
    }

    @GetMapping
    ResponseEntity<List<SportFacilities>> getAll() {
        LOGGER.info("Showing all the records in SportFacilities entity!");
        return ResponseEntity.ok(sportFacilitiesRepository.findAll());
    }
}
