package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubWriteModel;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Objects;

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
        if (bindingResult.hasErrors() ||
                writeModel.getAthleticsClubEquipment() == 0 ||
                writeModel.getEquipmentProducer() == 0 ||
                writeModel.getEquipmentStorage() == 0) {
            model.addAttribute("edit", false);
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodEquipmentCreate" : validation;
        }
        equipmentService.saveEquipment(writeModel);
        return "redirect:/equipment/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("equipment", new EquipmentWriteModel());
        model.addAttribute("edit", false);
        var validation = prepareEntryModel(model);
        return validation.isEmpty() ? "/prodEquipmentCreate" : validation;
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
        var validation = prepareEntryModel(model);
        return validation.isEmpty() ? "/prodEquipmentCreate" : validation;
    }

    @PostMapping("/edit/{idEquipment}")
    String editEquipment(@ModelAttribute("equipment") @Valid EquipmentWriteModel writeModel,
                         BindingResult bindingResult,
                         @PathVariable("idEquipment") String idEquipment,
                         Model model) {
        if (bindingResult.hasErrors() ||
                writeModel.getAthleticsClubEquipment() == 0 ||
                writeModel.getEquipmentProducer() == 0 ||
                writeModel.getEquipmentStorage() == 0) {
            log.warn("Errors founds, try to show them in view!");
            model.addAttribute("edit", true);
            var validation = prepareEntryModel(model);
            return validation.isEmpty() ? "/prodEquipmentCreate" : validation;
        }
        writeModel.setNumber(Integer.valueOf(idEquipment));
        equipmentService.modifyEquipment(writeModel);
        return "redirect:/equipment/getAll";
    }

    private String prepareEntryModel(Model model) {
        var producers = equipmentService.getFormattedProducers();
        if (producers.isEmpty()) {
            return "redirect:/producer";
        }
        var clubs = equipmentService.getFormattedClubs();
        if (clubs.isEmpty()) {
            return "redirect:/club";
        }
        var facilities = equipmentService.getFormattedFacilities();
        if (facilities.isEmpty()) {
            return "redirect:/facility";
        }
        model.addAttribute("producers", producers);
        model.addAttribute("clubs", clubs);
        model.addAttribute("facilities", facilities);
        model.addAttribute("maxDate", LocalDate.now().toString());
        return StringUtils.EMPTY;
    }
}
