package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    ResponseEntity<List<Address>> getAll() {
        LOGGER.info("Showing all the records in Addresses entity!");
        return ResponseEntity.ok(addressRepository.findAll());
    }


}
