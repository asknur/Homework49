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

    private Long id;
    @NotBlank(message = "Название обязательно")
    @Size(min = 5, max = 20)
    private String name;

    @NotBlank(message = "Название обязательно")
    @Size(min = 5, max = 50)
    private String description;

    @NotNull(message = "Название обязательно")
    @Min(1)
    @Max(10)
    @Positive
    private float salary;

    @NotNull(message = "Время обязательно")
    @Min(1)
    @Max(10)
    @Positive
    private int exp_from;

    @NotNull(message = "Время обязательно")
    @Min(1)
    @Max(10)
    @Positive
    private int exp_to;

    private boolean is_active;

    @NotNull(message = "Дата обязательно")
    private LocalDateTime created_date;

    @NotNull(message = "Дата обязательно")
    private LocalDateTime updated_time;

    private Long respondedCount;
}