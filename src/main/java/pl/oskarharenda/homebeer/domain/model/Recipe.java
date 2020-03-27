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
@Table(name="recipes")
@Getter
@Setter
@ToString(exclude = {"user", "opinions"})
@EqualsAndHashCode(of="id")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ingredients;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "recipe")
    private List<Opinion> opinions =
            new ArrayList<>();

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    private double avgNote() {
        double sum = 0;
        for (Opinion o : opinions) {
            sum += o.getNote();
        }
        double avg = sum / opinions.size();
        return avg;
    }



}
