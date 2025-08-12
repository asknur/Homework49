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

public class WorkExperienceInfoDto {
    @NotNull(message = "Название обязательно")
    @Size(min = 2, max = 10)
    @Positive
    private int years;

    @NotBlank(message = "Название обязательно")
    @Size(min = 2, max = 30)
    private String company_name;

    @NotBlank(message = "Название обязательно")
    @Size(min = 2, max = 30)
    private String position;

    @NotBlank(message = "Название обязательно")
    @Size(min = 2, max = 30)
    private String responsibilities;
}
