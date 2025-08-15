package kg.attractor.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "education_info")
public class EducationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int resume_id;
    @Column(length = 100)
    private String institution;
    @Column(length = 100)
    private String program;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    @Column(length = 100)
    private String degree;
}
