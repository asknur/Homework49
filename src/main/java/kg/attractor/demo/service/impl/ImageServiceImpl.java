package kg.attractor.demo.service.impl;

import kg.attractor.demo.dto.ImageDto;
import kg.attractor.demo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Override
    public ResponseEntity<?> getById(String filename){
        return downloadFile(filename,"images", MediaType.IMAGE_JPEG);
    }

    @Override
    public void create(ImageDto imageDto){
        String fileName = saveUploadedFile(imageDto.getFile(), "images");
        System.out.println(fileName);
    }

}