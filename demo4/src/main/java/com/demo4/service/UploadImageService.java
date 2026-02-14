package com.demo4.service;

import com.cloudinary.Cloudinary;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class UploadImageService {
    private final Cloudinary cloudinary ;
    public Map uploadFile(MultipartFile file) throws IOException{
        return cloudinary.uploader().upload(file.getBytes(), Map.of("folder", "image_book"));
    }
}
