package pl.edu.pw.elka.bdbt.athleticsclub.model.equipmentproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.model.owner.OwnersController;

import java.util.List;

@Controller
@RequestMapping("/equipmentproducers")
public class EquipmentProducersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OwnersController.class);
    private final EquipmentProducersRepository equipmentProducersRepository;

    public EquipmentProducersController(EquipmentProducersRepository equipmentProducersRepository) {
        this.equipmentProducersRepository = equipmentProducersRepository;
    }

    @GetMapping
    ResponseEntity<List<EquipmentProducers>> getAll() {
        LOGGER.info("Showing all the records in EquipmentProducers entity!");
        return ResponseEntity.ok(equipmentProducersRepository.findAll());
    }
}
