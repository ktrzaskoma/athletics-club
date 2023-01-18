package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubWriteModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/equipment")
@Log4j2
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var equipments = equipmentService.getEquipments();
        model.addAttribute("equipments", equipments);
        return "/prodEquipment";
    }

    @PostMapping("/create")
    String createEquipment(@ModelAttribute("equipment") @Valid
                                   EquipmentWriteModel writeModel,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntryModel(model);
            model.addAttribute("edit", false);
            return "/prodEquipmentCreate";
        }
        equipmentService.saveEquipment(writeModel);
        return "redirect:/equipment/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        prepareEntryModel(model);
        model.addAttribute("equipment", new EquipmentWriteModel());
        model.addAttribute("edit", false);
        return "/prodEquipmentCreate";
    }

    @GetMapping("/delete/{idEquipment}")
    String deleteEquipment(@PathVariable("idEquipment") String idEquipment) {
        log.info("Try to delete entry!");
        equipmentService.deleteEquipment(idEquipment);
        return "redirect:/equipment/getAll";
    }

    @GetMapping("/edit/{idEquipment}")
    String getEquipmentToEdit(@PathVariable("idEquipment") String idEquipment, Model model) {
        log.info("Try to edit entry!");
        var editEntity = equipmentService.editEquipment(idEquipment);
        model.addAttribute("equipment", editEntity);
        model.addAttribute("edit", true);
        prepareEntryModel(model);
        return "/prodEquipmentCreate";
    }

    @PostMapping("/edit/{idEquipment}")
    String editEquipment(@ModelAttribute("equipment") @Valid EquipmentWriteModel writeModel,
                    BindingResult bindingResult,
                    @PathVariable("idEquipment") String idEquipment,
                    Model model) {
        if (bindingResult.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            prepareEntryModel(model);
            model.addAttribute("edit", true);
            return "/prodEquipmentCreate";
        }
        writeModel.setNumber(Integer.valueOf(idEquipment));
        equipmentService.modifyEquipment(writeModel);
        return "redirect:/equipment/getAll";
    }

    private Model prepareEntryModel(Model model) {
        var producers = equipmentService.getFormattedProducers();
        var clubs = equipmentService.getFormattedClubs();
        var facilities = equipmentService.getFormattedFacilities();

        model.addAttribute("producers", producers);
        model.addAttribute("clubs", clubs);
        model.addAttribute("facilities", facilities);
        return model;
    }
}
