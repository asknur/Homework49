package kg.attractor.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Users {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private String phone_number;
    private String avatar;
    private String account_type;


}
