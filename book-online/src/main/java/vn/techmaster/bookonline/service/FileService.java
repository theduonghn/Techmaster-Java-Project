package vn.techmaster.bookonline.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import vn.techmaster.bookonline.exception.BadRequestException;
import vn.techmaster.bookonline.exception.StorageException;
import vn.techmaster.bookonline.util.Utils;

@Service
public class FileService {
    // Folder path to upload file
    private final Path rootPath = Paths.get("upload");
    private final Path bookThumbnailsPath = rootPath.resolve("book-thumbnails");

    public FileService() {
        createFolder(rootPath.toString());
    }

    // Create folder if not exists
    public void createFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Upload file
    public String uploadEmployerLogo(String id, MultipartFile file) {
        // Create employer logo path if not exist
        createFolder(bookThumbnailsPath.toString());

        // Validate file
        validate(file);

        // Create path of file
        File fileServer = new File(bookThumbnailsPath + "/" + id);
        try {
            // Use Buffer to store data
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileServer));
            stream.write(file.getBytes());
            stream.close();

            return id;
        } catch (Exception e) {
            throw new StorageException("Errors occur while uploading file");
        }
    }

    public void validate(MultipartFile file) {
        // Validate file name
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.equals("")) {
            throw new BadRequestException("Invalid file name");
        }

        // Validate file extension
        String fileExtension = Utils.getExtensionFile(fileName);
        if (!Utils.checkFileExtenstion(fileExtension)) {
            throw new BadRequestException("Invalid file");
        }

        // Check file size (upload below 2MB)
        if ((double) file.getSize() > (2 * 1024 * 1024)) {
            throw new BadRequestException("File must not excess 2MB");
        }
    }

    // Read logo
    public byte[] readImage(String imageName) {
        // Get file path
        Path path = bookThumbnailsPath.resolve(imageName);

        // Check if file path exists
        if (!Files.exists(path)) {
            throw new StorageException("Errors occur while reading file " + imageName);
        }

        try {
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() || resource.isReadable()) {
                InputStream inputStream = resource.getInputStream();
                byte[] byteArray = StreamUtils.copyToByteArray(inputStream);
                inputStream.close(); // Remember to close InputStream
                return byteArray;
            } else {
                throw new StorageException("Errors occur while reading file " + imageName);
            }
        } catch (Exception e) {
            throw new StorageException("Errors occur while reading file " + imageName);
        }
    }

    // Delete image
    public void deleteImage(String imagePath) {
        try {
            Files.deleteIfExists(Paths.get(imagePath));
        } catch (IOException e) {
            throw new StorageException("Errors occur while deleting file " + imagePath);
        }
    }
}
