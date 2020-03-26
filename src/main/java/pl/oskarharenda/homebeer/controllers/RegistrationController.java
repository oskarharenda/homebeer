package pl.oskarharenda.homebeer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.oskarharenda.homebeer.dtos.RegistrationDataDTO;
import pl.oskarharenda.homebeer.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model){
        model.addAttribute("data",new RegistrationDataDTO());
        return "registration/form";
    }

    @PostMapping
    public String processRegistrationPage(@Valid @ModelAttribute("data") RegistrationDataDTO data, BindingResult result){
        if (result.hasErrors()){
            return "registration/form";
        }

        //TODO: Jak przprowadzić te jeb$$$$$%%#%###@#$% rejestrację?!
        registrationService.RegisterUser(data);

        return "redirect:/login";
    }

}
