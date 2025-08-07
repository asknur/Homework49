package kg.attractor.demo.model;

import lombok.*;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private String phone_number;
    private String avatar;
    private String account_type;
    private Boolean enabled;
    private Long role_id;

}
