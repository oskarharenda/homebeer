package pl.oskarharenda.homebeer.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.oskarharenda.homebeer.domain.model.Opinion;
import pl.oskarharenda.homebeer.domain.model.User;
import pl.oskarharenda.homebeer.domain.repositories.OpinionRepository;
import pl.oskarharenda.homebeer.domain.repositories.RecipeRepository;
import pl.oskarharenda.homebeer.domain.repositories.UserRepository;
import pl.oskarharenda.homebeer.dtos.OpinionDataDTO;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OpinionService {
    private final OpinionRepository opinionRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    public OpinionService(OpinionRepository opinionRepository, RecipeRepository recipeRepository, UserRepository userRepository) {
        this.opinionRepository = opinionRepository;
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    public void addOpinion(OpinionDataDTO data, Long id){
        //log.debug("Dane : {}", data);
        Opinion opinion = new Opinion();
        opinion.setDescription(data.getDescription());
        opinion.setNote(data.getNote());
        opinion.setCreatedDate(new Date());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        opinion.setUser(user);
        opinion.setRecipe(recipeRepository.findById(id).get());

        opinionRepository.save(opinion);
    }
    public double getAvgNote(Long id) {
        List<Opinion> opinionList = opinionRepository.findAllByRecipeId(id);
        double sum = 0;
        double count = 0;
        for (Opinion opinion : opinionList) {
            sum += opinion.getNote();
            count++;
        }
        if (count == 0) return 0;
        return sum / count;
    }

}
