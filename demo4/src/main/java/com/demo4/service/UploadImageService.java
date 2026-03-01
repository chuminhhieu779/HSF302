package com.demo4.service;

import com.cloudinary.Cloudinary;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class UploadImageService {
    private final Cloudinary cloudinary ;
    public Map<String , Object>  uploadFile(MultipartFile file) throws IOException{
        Map<String ,Object> map =  cloudinary.uploader().upload(file.getBytes(), Map.of("folder", "test_image"));
        return map ;
    }

}
