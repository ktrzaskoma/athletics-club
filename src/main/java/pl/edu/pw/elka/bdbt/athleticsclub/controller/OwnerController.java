package pl.edu.pw.elka.bdbt.athleticsclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.OwnerRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Owner;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);
    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    ResponseEntity<List<Owner>> getAll() {
        LOGGER.info("Showing all the records in Owners entity!");
        return ResponseEntity.ok(ownerRepository.findAll());
    }
}
