package pl.oskarharenda.homebeer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarharenda.homebeer.dtos.RecipeDataDTO;
import pl.oskarharenda.homebeer.services.OpinionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/opinion")
public class OpinionController {
    final private OpinionService opinionService;

    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @PostMapping("/add")
    @ResponseBody
    public String addOpinionToRecipe(@ModelAttribute("recipes") RecipeDataDTO data){
        return data.toString();
    }
}
