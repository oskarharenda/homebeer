package pl.oskarharenda.homebeer.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.oskarharenda.homebeer.domain.model.Opinion;

import java.util.List;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long> {

    List<Opinion> findAllByRecipeId(Long recipe_id);
}
