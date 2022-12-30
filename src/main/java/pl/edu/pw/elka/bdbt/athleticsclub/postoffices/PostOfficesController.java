package pl.edu.pw.elka.bdbt.athleticsclub.postoffices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/postoffices")
public class PostOfficesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostOfficesController.class);
    private final PostOfficesRepository postOfficesRepository;

    public PostOfficesController(PostOfficesRepository postOfficesRepository) {
        this.postOfficesRepository = postOfficesRepository;
    }

    @GetMapping
    ResponseEntity<List<PostOffices>> getAll() {
        LOGGER.info("Showing all the records in PostOffices entity!");
        return ResponseEntity.ok(postOfficesRepository.findAll());
    }

}


