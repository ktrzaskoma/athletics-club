package pl.edu.pw.elka.bdbt.athleticsclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.AthleticsClub;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/athleticsclub")
public class AthleticsClubController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AthleticsClubController.class);
    private final AthleticsClubRepository athleticsClubRepository;

    public AthleticsClubController(final AthleticsClubRepository athleticsClubRepository) {
        this.athleticsClubRepository = athleticsClubRepository;
    }

    @GetMapping
    ResponseEntity<List<AthleticsClub>> getAll() {
        LOGGER.info("Showing all the records in AthleticsClub entity!");
        return ResponseEntity.ok(athleticsClubRepository.findAll());
    }

    @PostMapping
    ResponseEntity<AthleticsClub> creatAthleticsClub(@RequestBody AthleticsClub toCreat) {
        AthleticsClub athleticsClub = athleticsClubRepository.save(toCreat);
        return ResponseEntity.created(URI.create("/" + athleticsClub.getClubNumber())).body(athleticsClub);
    }

}
