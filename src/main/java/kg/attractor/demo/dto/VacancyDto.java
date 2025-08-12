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

public class VacancyDto {

    @NotBlank(message = "Название обязательно")
    @Size(min = 5, max = 20)
    private String name;

    @NotBlank(message = "Название обязательно")
    @Size(min = 5, max = 50)
    private String description;

    @NotNull(message = "Название обязательно")
    @Size(min = 1, max = 20)
    @Positive
    private float salary;

    @NotNull(message = "Время обязательно")
    @Size(min = 1, max = 20)
    @Positive
    private int exp_from;

    @NotNull(message = "Время обязательно")
    @Size(min = 1, max = 20)
    @Positive
    private int exp_to;

    private boolean is_active;

    @NotNull(message = "Дата обязательно")
    private LocalDateTime created_date;

    @NotNull(message = "Дата обязательно")
    private LocalDateTime updated_time;
}
