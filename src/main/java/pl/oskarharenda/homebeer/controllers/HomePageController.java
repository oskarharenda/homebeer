package pl.oskarharenda.homebeer.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String prepareHomePage(Model model, Principal principal){
        // dwie opcje dostanie się do urzytkownika zalogowanego
        String username = principal.getName();
        String username2 = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username1",username);
        model.addAttribute("username2",username2);
        return "home/main";
    }
}
