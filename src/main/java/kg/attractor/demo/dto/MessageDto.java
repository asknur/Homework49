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

public class MessageDto {

    @NotNull
    @Min(1)
    @Positive
    private int responded_applicants;

    @NotBlank
    @Size(min = 3, max = 20)
    private String content;

    @NotNull
    private LocalDateTime timestamp;
}
