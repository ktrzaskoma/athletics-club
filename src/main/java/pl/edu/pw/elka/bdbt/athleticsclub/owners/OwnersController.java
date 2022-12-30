package pl.edu.pw.elka.bdbt.athleticsclub.owners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnersController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnersController.class);
    private final OwnersRepository ownersRepository;

    public OwnersController(OwnersRepository ownersRepository) {
        this.ownersRepository = ownersRepository;
    }

    @GetMapping
    ResponseEntity<List<Owners>> getAll() {
        LOGGER.info("Showing all the records in Owners entity!");
        return ResponseEntity.ok(ownersRepository.findAll());
    }
}
