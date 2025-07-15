package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Vacancy {
    private int id;
    private String name;
    private String description;
    private int category_id;
    private float salary;
    private int exp_from;
    private int exp_to;
    private boolean is_active;
    private int author_id;
    private LocalDateTime created_date;
    private LocalDateTime updated_time;

}
