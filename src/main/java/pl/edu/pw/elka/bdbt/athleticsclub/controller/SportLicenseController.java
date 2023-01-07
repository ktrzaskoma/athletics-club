package pl.edu.pw.elka.bdbt.athleticsclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.SportLicenseRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.SportLicense;

import java.util.List;

@Controller
@RequestMapping("/sportlicenses")
public class SportLicenseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportFacilityController.class);
    private final SportLicenseRepository sportLicenseRepository;

    public SportLicenseController(SportLicenseRepository sportLicenseRepository) {
        this.sportLicenseRepository = sportLicenseRepository;
    }

    @GetMapping
    ResponseEntity<List<SportLicense>> getAll() {
        LOGGER.info("Showing all the records in SportLicenses entity!");
        return ResponseEntity.ok(sportLicenseRepository.findAll());
    }
}
