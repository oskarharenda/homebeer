package pl.oskarharenda.homebeer.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.oskarharenda.homebeer.domain.model.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    List<Recipe> findAllByUserUsername(String user_username);

    @Modifying
    @Query("update Recipe r set r.name = ?1, r.ingredients = ?2, r.description = ?3 where r.id = ?3")
    void setRecipeInfoById(String name, String ingredients,String description, Integer id);
}
