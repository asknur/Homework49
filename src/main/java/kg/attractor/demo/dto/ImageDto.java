package kg.attractor.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ImageDto {

    @NotBlank
    private MultipartFile file;

    @NotNull
    @Min(1)
    private long UserId;
}
