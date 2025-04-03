package com.yasithsandesh.cconnect_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/v1/upload")
public class UploadController {

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";


    @PostMapping
    public String uploadFile(@RequestParam("userId") String userId,@RequestParam("file") MultipartFile file) {
        try {
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = UPLOAD_DIR + "/" + userId+".jpg";
            file.transferTo(Paths.get(filePath));
            return "File uploaded successfully: " + filePath;

        } catch (IOException e) {
            e.printStackTrace();
            return "File upload failed!";
        }
    }

}
