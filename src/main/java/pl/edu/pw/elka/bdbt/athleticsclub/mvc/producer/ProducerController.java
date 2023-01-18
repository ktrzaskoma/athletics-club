package pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/producer")
@Log4j2
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var producers = producerService.getProducers();
        model.addAttribute("producers", producers);
        return "/prodProducer";
    }

    @PostMapping("/create")
    String createProducer(@ModelAttribute("producer") @Valid ProducerWriteModel producerWriteModel,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "/prodProducerCreate";
        }
        producerService.saveProducer(producerWriteModel);
        return "redirect:/producer/getAll";
    }

    @GetMapping("/delete/{idProducer}")
    String deleteProducer(@PathVariable("idProducer") String idProducer) {
        log.info("Try to delete entry!");
        producerService.deleteProducer(idProducer);
        return "redirect:/producer/getAll";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("producer", new ProducerWriteModel());
        model.addAttribute("edit", false);
        return "/prodProducerCreate";
    }

    @GetMapping("/edit/{idProducer}")
    String getProducerToEdit(@PathVariable("idProducer") String idProducer, Model model) {
        log.info("Try to edit entry!");
        var editEntity = producerService.editProducer(idProducer);
        model.addAttribute("producer", editEntity);
        model.addAttribute("edit", true);
        return "/prodProducerCreate";
    }

    @PostMapping("/edit/{idProducer}")
    String editProducer(@ModelAttribute("producer") @Valid ProducerWriteModel writeModel,
                        BindingResult bindingResult,
                        @PathVariable("idProducer") String idProducer,
                        Model model) {
        if (bindingResult.hasErrors()) {
            log.warn("Errors founds, try to show them in view!");
            model.addAttribute("edit", true);
            return "/prodProducerCreate";
        }
        writeModel.setNumber(Integer.valueOf(idProducer));
        producerService.saveProducer(writeModel);
        return "redirect:/producer/getAll";
    }
}
