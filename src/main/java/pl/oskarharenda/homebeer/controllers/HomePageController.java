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
        if(principal!=null){
            String username = principal.getName();
            model.addAttribute("username1",username);
        }
        return "home/main";
    }
}
