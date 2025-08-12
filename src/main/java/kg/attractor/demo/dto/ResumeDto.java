package kg.attractor.demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ResumeDto {
    @NotBlank(message = "Имя обязательно")
    @Size(min = 2,  max = 20)
    private String name;

    @NotNull(message = "Зарплата обязательно")
    @Size(min = 1,  max = 20)
    private float salary;

    @NotNull
    private boolean is_active;

    @NotNull(message = "Дава обязательно")
    private LocalDateTime created_date;

    @NotNull(message = "Дата обязательно")
    private LocalDateTime update_time;
}
