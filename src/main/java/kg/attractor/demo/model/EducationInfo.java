package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EducationInfo {
    private int id;
    private int resume_id;
    private String institution;
    private String program;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String degree;
}
