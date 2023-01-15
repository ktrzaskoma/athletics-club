package pl.edu.pw.elka.bdbt.athleticsclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class LoginController {

    @GetMapping
    public String welcomePage() {
        return "startPage";
    }

    @GetMapping
    public String loginPage() {
        return "login";
    }





}
