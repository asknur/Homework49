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
public class EducationInfoDto {
    @NotBlank(message = "Название обязательно")
    @Size(min = 3, max = 20)
    private String institution;

    @NotBlank(message = "Название обязательно")
    @Size(min = 3, max = 20)
    private String program;

    @NotNull(message = "Дата обязательно")
    private LocalDateTime start_date;

    @NotNull(message = "Дата обязательно")
    private LocalDateTime end_date;

    @NotBlank(message = "Название обязательно")
    @Size(min = 5, max = 20)
    private String degree;
}
