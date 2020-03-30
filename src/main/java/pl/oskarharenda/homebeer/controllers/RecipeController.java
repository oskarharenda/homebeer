package pl.oskarharenda.homebeer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.oskarharenda.homebeer.domain.repositories.RecipeRepository;
import pl.oskarharenda.homebeer.dtos.RecipeDataDTO;
import pl.oskarharenda.homebeer.services.OpinionService;
import pl.oskarharenda.homebeer.services.RecipeService;

import javax.validation.Valid;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    final private RecipeService recipeService;
    final private OpinionService opinionService;
    final private RecipeRepository recipeRepository;

    public RecipeController(RecipeService addRecipeService, RecipeService recipeService, OpinionService opinionService, RecipeRepository recipeRepository) {
        this.recipeService = recipeService;
        this.opinionService = opinionService;
        this.recipeRepository = recipeRepository;
    }


    @GetMapping("/add")
    public String addRecipe(Model model){
        model.addAttribute("data",new RecipeDataDTO());
        return "recipe/add";
    }

    @PostMapping("/add")
    public String processAddRecipe(@Valid @ModelAttribute("data") RecipeDataDTO data, BindingResult result, Model model){
        if(result.hasErrors()){
            return "recipe/add";
        }
        recipeService.addRecipe(data);
        model.addAttribute("recipe", data);
        model.addAttribute("recipes",recipeService.findAllRecipe());
        return "recipe/added";
    }

    @GetMapping("/all")
    public String allRecipes(Model model){
        model.addAttribute("recipes2", recipeService.recipesWithNotes());
        model.addAttribute("recipes", recipeService.findAllRecipe());
        return "recipe/allRecipes";
    }

    @GetMapping("/allByRate")
    public String allBy(Model model){
        model.addAttribute("sorted",recipeService.recipesByRate());
        return "recipe/allByRate";
    }

    @GetMapping("/user")
    public String userRecipes(Model model){
        model.addAttribute("userRecipes", recipeService.findAllByUser());
        return "recipe/userRecipes";
    }

    @GetMapping("/edit/{id}")
        public String editRecipe(Model model, @PathVariable Long id) {
        model.addAttribute("userRecipe", new RecipeDataDTO());
        model.addAttribute("userId",id);
        model.addAttribute("recipe",recipeRepository.findById(id).get());
        return "recipe/edit";
    }

    @PostMapping("/edit/{id}")
    public String processEditRecipe(@Valid @ModelAttribute("userRecipe") RecipeDataDTO data, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return("recipe/userRecipes");
        }
        recipeService.editRecipe(data,id);
        return "recipe/userRecipes";
    }
}
