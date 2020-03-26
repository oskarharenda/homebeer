package pl.oskarharenda.homebeer.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(of="id")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Min(value=1)
    @Max(value = 10)
    private Double note;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Recipe recipe;
}
