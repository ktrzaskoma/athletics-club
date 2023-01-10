package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportfacility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sportfacilities")
public class SportFacilityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportFacilityController.class);
    private final SportFacilityRepository sportFacilityRepository;

    public SportFacilityController(SportFacilityRepository sportFacilityRepository) {
        this.sportFacilityRepository = sportFacilityRepository;
    }

    @GetMapping
    ResponseEntity<List<SportFacilityReadModel>> getAll() {
        LOGGER.info("Showing all the records in SportFacilities entity!");
        var list = sportFacilityRepository.findAll().stream()
                .map(SportFacilityReadModel::toReadModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
