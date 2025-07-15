package kg.attractor.demo.model;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder

public class Message {
    private int id;
    private int responded_applicants;
    private String content;
    private LocalDateTime timestamp;


}
