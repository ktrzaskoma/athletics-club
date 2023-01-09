package pl.edu.pw.elka.bdbt.athleticsclub.mvc.postoffice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/postoffices")
public class PostOfficeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostOfficeController.class);
    private final PostOfficeRepository postOfficeRepository;

    public PostOfficeController(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    @GetMapping
    ResponseEntity<List<PostOffice>> getAll() {
        LOGGER.info("Showing all the records in PostOffices entity!");
        return ResponseEntity.ok(postOfficeRepository.findAll());
    }

}


