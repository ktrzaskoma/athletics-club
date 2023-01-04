package pl.edu.pw.elka.bdbt.athleticsclub.model.postoffice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/postoffices")
public class PostOfficesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostOfficesController.class);
    private final PostOfficesRepository postOfficesRepository;

    public PostOfficesController(PostOfficesRepository postOfficesRepository) {
        this.postOfficesRepository = postOfficesRepository;
    }


    /**
     * Special request for testing front end
     * @return postoffice.html
     */
    @GetMapping
    String showPostoffices(Model model) {
        var postOfficesToEdit = new PostOffices();
        postOfficesToEdit.setZipCode("1111");
        model.addAttribute("postoffice",postOfficesToEdit);
        return "postoffice";
    }

    @GetMapping("/post")
    ResponseEntity<List<PostOffices>> getAll() {
        LOGGER.info("Showing all the records in PostOffices entity!");
        return ResponseEntity.ok(postOfficesRepository.findAll());
    }

    @PostMapping
    ResponseEntity<PostOffices> creatPostOffice(@RequestBody PostOffices toCreat) {
        PostOffices postOffices = postOfficesRepository.save(toCreat);
        return ResponseEntity.created(URI.create("/" + postOffices.getPostOfficeNumber())).body(postOffices);
    }



}


