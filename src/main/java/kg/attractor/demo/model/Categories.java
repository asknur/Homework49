package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categories {
    private int id;
    private String name;
    private int parent_id;

}
