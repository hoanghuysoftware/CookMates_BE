package com.cookmates.backend.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cookmates.backend.model.Image;
import com.cookmates.backend.model.Recipe;
import com.cookmates.backend.model.Step;
import com.cookmates.backend.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ImageUtils {
    private final ImageRepository imageRepository;
    private final Cloudinary cloudinary;

    public Image uploadImage(MultipartFile file, Step step){
        try {
            // Upload lên Cloudinary
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("folder", "recipes"));

            String imageUrl = (String) uploadResult.get("secure_url");
            String publicId = (String) uploadResult.get("public_id");

            // Luu vao DB
            Image image = Image.builder()
                    .step(step)
                    .imageUrl(imageUrl)
                    .public_id(publicId)
                    .build();
            return imageRepository.save(image);
        }catch (IOException e){
            throw new RuntimeException("Upload image failed", e);
        }
    }
}
