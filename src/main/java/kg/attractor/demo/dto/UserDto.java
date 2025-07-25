package kg.attractor.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank
    @Size(min = 5, max = 20)
    private String name;

    @NotBlank
    @Size(min = 5, max = 20)
    private String surname;

    @Positive
    @Min(1)
    private int age;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 5, max = 20, message = "Lenght must be minimum 5 symbols and maximum 20 symbols")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
            message = " Should contain at least one uppercase letter and one number")
    private String password;

    @NotBlank
    private String phone_number;

    @NotBlank
    private String avatar;

    @NotBlank
    @Size(min = 5,max = 15)
    private String account_type;
}
