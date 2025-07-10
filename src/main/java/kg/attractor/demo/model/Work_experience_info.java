package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Work_experience_info {
    private int id;
    private int resume_id;
    private int years;
    private String company_name;
    private String position;
    private String responsibilities;

}
