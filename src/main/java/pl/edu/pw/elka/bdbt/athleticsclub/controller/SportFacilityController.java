package pl.edu.pw.elka.bdbt.athleticsclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.SportFacilityRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.dto.SportFacilityDTO;

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
    ResponseEntity<List<SportFacilityDTO>> getAll() {
        LOGGER.info("Showing all the records in SportFacilities entity!");
        var list = sportFacilityRepository.findAll().stream()
                .map(SportFacilityDTO::toSportFaciltiesDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
