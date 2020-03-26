package pl.oskarharenda.homebeer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.oskarharenda.homebeer.domain.model.Recipe;
import pl.oskarharenda.homebeer.domain.repositories.RecipeRepository;
import pl.oskarharenda.homebeer.dtos.OpinionDataDTO;

import pl.oskarharenda.homebeer.services.OpinionService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/opinion")
public class OpinionController {
    private final RecipeRepository recipeRepository;


    final private OpinionService opinionService;

    public OpinionController(RecipeRepository recipeRepository, OpinionService opinionService) {
        this.recipeRepository = recipeRepository;
        this.opinionService = opinionService;
    }

    @GetMapping("/add/{id}")
    public String addOpinionToRecipe(@PathVariable Long id, Model model){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent()){
            model.addAttribute("recipe",recipe.get());
            model.addAttribute("opinion", new OpinionDataDTO());
            return "opinion/add";
        }
        return "recipe/allRecipes";
    }

    @PostMapping("/add")
    public String processAddOpinion(@Valid @ModelAttribute("opinion") OpinionDataDTO opinionDataDTO,  BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "recipe/add";
        }
        opinionService.addOpinion(opinionDataDTO);
        return "recipe/allRecipes";
    }
}
