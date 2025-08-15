package kg.attractor.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "education_info")
public class EducationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Resume resume_id;

    @Column(length = 100)
    private String institution;

    @Column(length = 100)
    private String program;

    private Timestamp start_date;

    private Timestamp end_date;

    @Column(length = 100)
    private String degree;
}
