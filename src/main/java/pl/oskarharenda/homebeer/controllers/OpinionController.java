package pl.oskarharenda.homebeer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.oskarharenda.homebeer.domain.model.Opinion;
import pl.oskarharenda.homebeer.domain.model.Recipe;
import pl.oskarharenda.homebeer.domain.repositories.OpinionRepository;
import pl.oskarharenda.homebeer.domain.repositories.RecipeRepository;
import pl.oskarharenda.homebeer.dtos.OpinionDataDTO;

import pl.oskarharenda.homebeer.services.OpinionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/opinion")
public class OpinionController {
    private final RecipeRepository recipeRepository;
    private final OpinionRepository opinionRepository;


    final private OpinionService opinionService;

    public OpinionController(RecipeRepository recipeRepository, OpinionRepository opinionRepository, OpinionService opinionService) {
        this.recipeRepository = recipeRepository;
        this.opinionRepository = opinionRepository;
        this.opinionService = opinionService;
    }

    @GetMapping("/add/{id}")
    public String addOpinionToRecipe(@PathVariable Long id, Model model){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        List<Opinion> opinions = opinionRepository.findAllByRecipeId(id);
        model.addAttribute("opinions",opinions);
        if(recipe.isPresent()){
            model.addAttribute("recipe",recipe.get());
            model.addAttribute("opinion", new OpinionDataDTO());
            return "opinion/add";
        }
        return "recipe/allRecipes";
    }

    @PostMapping("/add/{id}")

    public String processAddOpinion(@PathVariable Long id, @Valid @ModelAttribute("opinion") OpinionDataDTO opinionDataDTO,  BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "recipe/add";
        }
        model.addAttribute("recipe", recipeRepository.findById(id).get());
        opinionService.addOpinion(opinionDataDTO, id);
        return "opinion/added";
    }
}
