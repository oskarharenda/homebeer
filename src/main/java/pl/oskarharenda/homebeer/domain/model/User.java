package pl.oskarharenda.homebeer.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString(exclude ={"password", "recipes", "opinions"} )
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean active = false;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes =
            new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Opinion> opinions =
            new ArrayList<>();
}
