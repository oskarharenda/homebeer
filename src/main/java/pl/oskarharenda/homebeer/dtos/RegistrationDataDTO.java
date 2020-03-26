package pl.oskarharenda.homebeer.dtos;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString(exclude = "password")
public class RegistrationDataDTO {

    @NotBlank @Size(min=3, max=12)
    private String username;

    @NotBlank @Size(min=3, max=12)
    private String password;
    private String firstName;
    private String lastName;
    @NotBlank @Email
    private String email;
    private Date createdDate;
}
