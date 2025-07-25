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

    @NotNull
    @Min(1)
    @Positive
    private int resume_id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String institution;

    @NotBlank
    @Size(min = 3, max = 20)
    private String program;

    @NotNull
    private LocalDateTime start_date;

    @NotNull
    private LocalDateTime end_date;

    @NotBlank
    @Size(min = 5, max = 20)
    private String degree;
}
