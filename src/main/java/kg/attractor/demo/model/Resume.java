package kg.attractor.demo.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    private int id;
    private int applicant_id;
    private String name;
    private int category_id;
    private float salary;
    private boolean is_active;
    private LocalDateTime created_date;
    private LocalDateTime update_time;

}
