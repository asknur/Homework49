package kg.attractor.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    private float salary;
    private int exp_from;
    private int exp_to;
    private boolean is_active;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author_id;

    private LocalDateTime created_date;
    private LocalDateTime updated_time;

}
