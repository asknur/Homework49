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

public class RespondedApplicantDto {

    @NotNull
    @Min(1)
    @Positive
    private int resume_id;

    @NotNull
    @Min(1)
    private int vacancy_id;

    private boolean confirmation;
}
