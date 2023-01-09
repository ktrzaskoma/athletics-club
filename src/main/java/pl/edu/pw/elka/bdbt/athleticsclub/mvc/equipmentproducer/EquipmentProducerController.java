package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipmentproducer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipmentproducer")
public class EquipmentProducerController {

    private final EquipmentProducerRepository equipmentProducerRepository;

    public EquipmentProducerController(EquipmentProducerRepository equipmentProducerRepository) {
        this.equipmentProducerRepository = equipmentProducerRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var equipmentproducers = equipmentProducerRepository.findAll()
                .stream().map(
                        EquipmentProducerReadModel::toReadModel
                ).toList();

        model.addAttribute("equipmentproducers", equipmentproducers);

        return "/equipmentproducer";
    }

    @PostMapping("/create")
    String createClub(@ModelAttribute("equipmentproducer") EquipmentProducerWriteModel writeModel) {
        equipmentProducerRepository.save(EquipmentProducerWriteModel.toWriteModel(writeModel));
        return "/equipmentproducer";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("equipmentproducer", new EquipmentProducerWriteModel());
        return "/equipmentproducer";
    }
}
