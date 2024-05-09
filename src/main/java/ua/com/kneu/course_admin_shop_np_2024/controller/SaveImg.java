package ua.com.kneu.course_admin_shop_np_2024.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class SaveImg {

    @Value("${upload.dir}")
    private String UPLOAD_DIR;


    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("fileToUpload") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String fileName = file.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR + fileName);
                Files.write(path, bytes);
            } catch (IOException e) {
                return "Помилка при збереженні файлу: " + e.getMessage();
            }
        }


        return "redirect:/product-manager";
    }


}
