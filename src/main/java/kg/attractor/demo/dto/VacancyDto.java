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

    @NotBlank
    @Size(min = 5, max = 20)
    private String name;

    @NotBlank
    @Size(min = 5, max = 50)
    private String description;

    @NotNull
    @Min(1)
    @Positive
    private int category_id;

    @NotNull
    @Size(min = 1, max = 20)
    @Positive
    private float salary;

    @NotNull
    @Size(min = 1, max = 20)
    @Positive
    private int exp_from;

    @NotNull
    @Size(min = 1, max = 20)
    @Positive
    private int exp_to;

    private boolean is_active;

    @NotNull
    @Min(1)
    private int author_id;

    @NotNull
    private LocalDateTime created_date;

    @NotNull
    private LocalDateTime updated_time;
}
