package kg.attractor.demo.dto;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String accountType;
}
