package pl.edu.pw.elka.bdbt.athleticsclub.model.address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/addresses")
public class AddressesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressesController.class);
    private final AddressesRepository addressesRepository;

    public AddressesController(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    @GetMapping
    ResponseEntity<List<Addresses>> getAll() {
        LOGGER.info("Showing all the records in Addresses entity!");
        return ResponseEntity.ok(addressesRepository.findAll());
    }


}
