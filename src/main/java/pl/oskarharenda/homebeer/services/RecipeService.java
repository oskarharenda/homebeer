package pl.oskarharenda.homebeer.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.oskarharenda.homebeer.domain.model.Recipe;
import pl.oskarharenda.homebeer.domain.model.User;
import pl.oskarharenda.homebeer.domain.repositories.RecipeRepository;
import pl.oskarharenda.homebeer.domain.repositories.UserRepository;
import pl.oskarharenda.homebeer.dtos.RecipeDataDTO;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;


    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }


    public void addRecipe(RecipeDataDTO data) {
        Recipe recipe = new Recipe();
        recipe.setName(data.getName());
        recipe.setIngredients(data.getIngredients());
        recipe.setDescription(data.getDescription());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        recipe.setUser(user);

        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
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
}
