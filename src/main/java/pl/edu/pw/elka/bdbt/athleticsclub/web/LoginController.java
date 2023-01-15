package pl.edu.pw.elka.bdbt.athleticsclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping
    public String viewHomePage() {
        return "startPage";
    }


//    @GetMapping("/login")
//    public String viewLoginPage() {
//        return "login";
//    }





}
