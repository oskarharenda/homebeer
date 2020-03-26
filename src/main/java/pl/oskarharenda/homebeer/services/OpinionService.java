package pl.oskarharenda.homebeer.services;

import org.springframework.stereotype.Service;
import pl.oskarharenda.homebeer.domain.model.Opinion;
import pl.oskarharenda.homebeer.domain.repositories.OpinionRepository;
import pl.oskarharenda.homebeer.domain.repositories.RecipeRepository;
import pl.oskarharenda.homebeer.dtos.OpinionDataDTO;
import pl.oskarharenda.homebeer.dtos.RecipeDataDTO;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class OpinionService {
    private final OpinionRepository opinionRepository;
    private final RecipeRepository recipeRepository;

    public OpinionService(OpinionRepository opinionRepository, RecipeRepository recipeRepository) {
        this.opinionRepository = opinionRepository;
        this.recipeRepository = recipeRepository;
    }

    public void addOpinion(OpinionDataDTO data){
        //log.debug("Dane : {}", data);
        Opinion opinion = new Opinion();
        opinion.setDescription(data.getDescription());
        opinion.setNote(data.getNote());
        opinion.setCreatedDate(new Date());
        opinion.setUser(data.getUser());

        opinionRepository.save(opinion);
    }

}
