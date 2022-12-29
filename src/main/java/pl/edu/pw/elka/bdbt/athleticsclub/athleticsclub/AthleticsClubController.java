package pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/athleticclub")
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
        return ResponseEntity.created(URI.create("/" + athleticsClub.getId())).body(athleticsClub);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateAthleticsClub(@PathVariable Integer id, @RequestBody @Valid AthleticsClub toUpdate) {
        if (!athleticsClubRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        athleticsClubRepository.findById(id)
                .ifPresent(athleticsClub -> {
                    athleticsClub.updateFormOfAthleticClub(toUpdate);
                    athleticsClubRepository.save(athleticsClub);
                });
        return ResponseEntity.noContent().build();
    }

//    TODO: after calling this request error 500 display
    @DeleteMapping("/{id}")
    public void deleteAthleticClub(@PathVariable Integer id) {
        if (!athleticsClubRepository.existsById(id)) {
            ResponseEntity.notFound().build();
        } LOGGER.info("Deleting athletics club " + id);
        athleticsClubRepository.deleteById(id);
    }
}
