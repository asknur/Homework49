package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactsInfo {
    private int id;
    private int type_id;
    private int resume_id;
    private String value;


}
