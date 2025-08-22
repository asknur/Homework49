package kg.attractor.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "responded_applicants")
public class RespondedApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume_id;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    private boolean confirmation;

}
