package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportequipment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipment")
public class SportEquipmentController {

    private final SportEquipmentRepository sportEquipmentRepository;

    public SportEquipmentController(SportEquipmentRepository sportEquipmentRepository) {
        this.sportEquipmentRepository = sportEquipmentRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var equipments = sportEquipmentRepository.findAll()
                .stream().map(
                        SportEquipmentReadModel::toReadModel
                ).toList();
        model.addAttribute("equipments", equipments);
        return "/equipment";
    }

    @PostMapping("/create")
    String createLicense(@ModelAttribute("equipment") SportEquipmentWriteModel equipmentWriteModel) {
        sportEquipmentRepository.save(SportEquipmentWriteModel.toWriteModel(equipmentWriteModel));
        return "/equipment";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("equipment", new SportEquipmentWriteModel());
        return "/equipment";
    }
}
