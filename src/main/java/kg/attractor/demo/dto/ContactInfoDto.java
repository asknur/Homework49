package kg.attractor.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ContactInfoDto {
    @NotBlank
    @Size(min = 3, max = 20)
    private String value;
}
