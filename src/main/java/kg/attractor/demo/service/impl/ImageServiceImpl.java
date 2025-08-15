package kg.attractor.demo.service.impl;

import kg.attractor.demo.dto.ImageDto;
import kg.attractor.demo.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {
    @Override
    public ResponseEntity<?> getById(String filename){
        log.info("Getting image by id: {}", filename);
        return downloadFile(filename,"images", MediaType.IMAGE_JPEG);
    }

    @Override
    public void create(ImageDto imageDto){
        log.info("Creating image: {}", imageDto);
        String fileName = saveUploadedFile(imageDto.getFile(), "images");
        System.out.println(fileName);
    }

}