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
    private Category category;

    private float salary;
    private int exp_from;
    private int exp_to;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

}
