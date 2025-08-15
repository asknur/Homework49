package kg.attractor.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private User applicant_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    private float salary;
    private boolean is_active;
    private LocalDateTime created_date;
    private LocalDateTime update_time;

}
