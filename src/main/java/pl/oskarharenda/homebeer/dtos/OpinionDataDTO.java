package pl.oskarharenda.homebeer.dtos;

import lombok.Data;
import pl.oskarharenda.homebeer.domain.model.Recipe;
import pl.oskarharenda.homebeer.domain.model.User;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
public class OpinionDataDTO {

    private String description;
    @Min(value = 1)
    @Max(value = 10)
    private Double note;
    private User user;
    private Recipe recipe;
    private Date createdDate;

}
