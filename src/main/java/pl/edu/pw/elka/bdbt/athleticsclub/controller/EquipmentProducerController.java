package pl.edu.pw.elka.bdbt.athleticsclub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.elka.bdbt.athleticsclub.dao.EquipmentProducerRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.model.EquipmentProducer;

import java.util.List;

@Controller
@RequestMapping("/equipmentproducers")
public class EquipmentProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);
    private final EquipmentProducerRepository equipmentProducerRepository;

    public EquipmentProducerController(EquipmentProducerRepository equipmentProducerRepository) {
        this.equipmentProducerRepository = equipmentProducerRepository;
    }

    @GetMapping
    ResponseEntity<List<EquipmentProducer>> getAll() {
        LOGGER.info("Showing all the records in EquipmentProducers entity!");
        return ResponseEntity.ok(equipmentProducerRepository.findAll());
    }
}
