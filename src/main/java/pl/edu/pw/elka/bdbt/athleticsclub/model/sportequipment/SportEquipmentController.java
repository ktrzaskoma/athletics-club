package pl.edu.pw.elka.bdbt.athleticsclub.model.sportequipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sportequipment")
public class SportEquipmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportEquipmentController.class);
    private final SportEquipmentRepository sportEquipmentRepository;

    public SportEquipmentController(SportEquipmentRepository sportEquipmentRepository) {
        this.sportEquipmentRepository = sportEquipmentRepository;
    }

    @GetMapping
    ResponseEntity<List<SportEquipment>> getAll() {
        LOGGER.info("Showing all the records in SportEquipment entity!");
        return ResponseEntity.ok(sportEquipmentRepository.findAll());
    }
}
