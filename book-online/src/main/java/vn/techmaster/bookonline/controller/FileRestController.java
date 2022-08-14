package vn.techmaster.bookonline.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import vn.techmaster.bookonline.service.FileService;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class FileRestController {
    private FileService fileService;

    @GetMapping(value = "upload/book-thumbnails/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] readImage(@PathVariable("imageName") String imageName) {
        return fileService.readImage(imageName);
    }
}
