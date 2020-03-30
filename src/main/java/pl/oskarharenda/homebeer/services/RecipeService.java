package pl.oskarharenda.homebeer.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.oskarharenda.homebeer.domain.model.Opinion;
import pl.oskarharenda.homebeer.domain.model.Recipe;
import pl.oskarharenda.homebeer.domain.model.User;
import pl.oskarharenda.homebeer.domain.repositories.OpinionRepository;
import pl.oskarharenda.homebeer.domain.repositories.RecipeRepository;
import pl.oskarharenda.homebeer.domain.repositories.UserRepository;
import pl.oskarharenda.homebeer.dtos.RecipeDataDTO;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Stream;

@Service
@Transactional
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final OpinionService opinionService;
    private final OpinionRepository opinionRepository;


    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository, OpinionService opinionService, OpinionRepository opinionRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.opinionService = opinionService;
        this.opinionRepository = opinionRepository;
    }


    public void addRecipe(RecipeDataDTO data) {
        Recipe recipe = new Recipe();
        recipe.setName(data.getName());
        recipe.setIngredients(data.getIngredients());
        recipe.setDescription(data.getDescription());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        recipe.setUser(user);


        Date date = new Date();
        recipe.setCreatedDate(date);

        recipeRepository.save(recipe);
    }

    public List<Recipe> findAllRecipe(){
        return recipeRepository.findAll();
    }
    public List<Recipe> findAllByUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return recipeRepository.findAllByUserUsername(username);
    }
    public Optional<Recipe> findById(Long id){
        return recipeRepository.findById(id);
    }


    public Map<Recipe, Double> recipesWithNotes(){
        Map <Recipe, Double> recipesWithNotes = new HashMap<>();
        List<Recipe> recipes = recipeRepository.findAll();
        for(Recipe recipe : recipes){
            recipesWithNotes.put(recipe,opinionService.getAvgNote(recipe.getId()));
        }
        return recipesWithNotes;
    }

    public void editRecipe(RecipeDataDTO data, Long id) {
        Recipe recipe = recipeRepository.getOne(id);
        recipe.setName(data.getName());
        recipe.setDescription(data.getDescription());
        recipe.setIngredients(data.getIngredients());
        recipeRepository.save(recipe);
    }

    public List<RecipeDataDTO>recipesByRate(){
        List<RecipeDataDTO> list = new ArrayList<>();
        List<Recipe> all = recipeRepository.findAll();

        for(Recipe recipe : all){
            RecipeDataDTO recipeDataDTO = new RecipeDataDTO();
            recipeDataDTO.setName(recipe.getName());
            recipeDataDTO.setDescription(recipe.getDescription());
            recipeDataDTO.setIngredients(recipe.getIngredients());
            Double count = 0.0;
            Double sum = 0.0;
            List<Opinion> allByRecipeId = opinionRepository.findAllByRecipeId(recipe.getId());
            for(Opinion opinion : allByRecipeId){
                sum+=opinion.getNote();
                count++;
            }
            if(count==0) recipeDataDTO.setAvgNotes(0.0);
            else recipeDataDTO.setAvgNotes(sum/count);
            list.add(recipeDataDTO);
        }
        list.sort(Comparator.comparing(RecipeDataDTO::getAvgNotes).reversed());
        return list;
    }
}
