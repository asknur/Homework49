package kg.attractor.demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    @NotBlank(message = "Имя обязательно")
    @Size(min = 5, max = 20)
    private String name;

    @NotBlank(message = "Фамилие обязательно")
    @Size(min = 5, max = 20)
    private String surname;

    @NotNull(message = "Возраст обязательно")
    @Positive
    @Min(1)
    private int age;

    @Email
    @NotBlank(message = "Почта обязательно")
    private String email;

    @NotBlank(message = "Пароль обязательно")
    @Size(min = 5, max = 20, message = "Length must be minimum 5 symbols and maximum 20 symbols")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
            message = " Should contain at least one uppercase letter and one number")
    private String password;

    @NotBlank(message = "Номер обязательно")
    private String phone_number;

    @NotBlank(message = "Аватар обязательно")
    private String avatar;

    @NotBlank(message = "Тип аккаунта обязательно")
    @Size(min = 5,max = 15)
    private String account_type;

    private Boolean enabled;

    @NotNull(message = "Название обязательно")
    private Long role_id;
}
