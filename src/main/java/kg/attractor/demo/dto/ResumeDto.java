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
    @NotBlank
    @Size(min = 2,  max = 20)
    private String name;

    @NotNull
    @Size(min = 1,  max = 20)
    private float salary;

    @NotNull
    private boolean is_active;

    @NotNull
    private LocalDateTime created_date;

    @NotNull
    private LocalDateTime update_time;
}
