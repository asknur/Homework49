package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Responded_applicant {
    private int id;
    private int resume_id;
    private int vacancy_id;
    private boolean confirmation;

}
