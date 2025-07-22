package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactType {
    private int id;
    private String type;

}
