package pl.edu.pw.elka.bdbt.athleticsclub.mvc.postoffice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/postoffice")
public class PostOfficeController {

    private final PostOfficeRepository postOfficeRepository;

    public PostOfficeController(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        var postoffices = postOfficeRepository.findAll()
                .stream().map(
                        PostOfficeReadModel::toReadModel
                ).toList();
        model.addAttribute("postoffices", postoffices);
        model.addAttribute("postoffice", new PostOfficeWriteModel());
        return "/postoffice";
    }

    @PostMapping("/create")
    String createClub(@ModelAttribute("postoffice") @Valid
                      PostOfficeWriteModel postOfficeWriteModel,
                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/postoffice";
        }
        postOfficeRepository.save(PostOfficeWriteModel.toEntity(postOfficeWriteModel));
        return "/postoffice";
    }

    @GetMapping
    String viewPage(Model model) {
        model.addAttribute("postoffice", new PostOfficeWriteModel());
        return "/postoffice";
    }

}


