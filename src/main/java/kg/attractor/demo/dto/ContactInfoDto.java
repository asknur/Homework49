package kg.attractor.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ContactInfoDto {

    @NotNull
    @Min(1)
    @Positive
    private int type_id;

    @NotNull
    @Min(1)
    @Positive
    private int resume_id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String value;
}
