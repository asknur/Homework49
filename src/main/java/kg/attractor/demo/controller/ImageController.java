package kg.attractor.demo.controller;

import kg.attractor.demo.dto.ImageDto;
import kg.attractor.demo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;


    @GetMapping
    public ResponseEntity<?> getImage(@RequestParam(name = "filename")String filename){
        return imageService.getById(filename);
    }

    @PostMapping
    public HttpStatus create(@RequestBody ImageDto imageDto){
        imageService.create(imageDto);
        return HttpStatus.CREATED;
    }

}
