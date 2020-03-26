package pl.oskarharenda.homebeer.dtos;

import lombok.Data;
import pl.oskarharenda.homebeer.domain.model.User;

import java.util.Date;

@Data
public class RecipeDataDTO {


    private String name;
    private String ingredients;
    private String description;
    private User user;
    private Date createdDate;

}
