package pl.edu.pw.elka.bdbt.athleticsclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class MainController {

    @GetMapping
    public String addMain() {
        return "/home.html";
    }

}
