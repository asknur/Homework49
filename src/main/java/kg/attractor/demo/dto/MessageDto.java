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

    @NotNull(message = "Название обязательно")
    @Min(1)
    @Positive
    private int responded_applicants;

    @NotBlank(message = "Название обязательно")
    @Size(min = 3, max = 20)
    private String content;

    @NotNull(message = "Дата обязательно")
    private LocalDateTime timestamp;
}
