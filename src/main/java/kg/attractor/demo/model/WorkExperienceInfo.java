package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkExperienceInfo {
    private int id;
    private int resume_id;
    private int years;
    private String company_name;
    private String position;
    private String responsibilities;

}
