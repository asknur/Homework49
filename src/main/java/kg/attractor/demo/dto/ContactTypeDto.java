package kg.attractor.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ContactTypeDto {

    @NotBlank(message = "Тип обязательно")
    @Size(min = 3, max = 20)
    private String type;
}

