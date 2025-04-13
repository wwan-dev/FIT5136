package com.example.demo.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@Controller

public class VideoController {
    @RequestMapping("/video") //监听hello请求
    public String videoPlayer(Model model) {
        model.addAttribute("name", "Thymeleaf");
        return "VideoPlayer";
    }
    @GetMapping("/video/transfer")
    public ResponseEntity<Resource> downloadFile(@RequestParam("m3u8Url") String m3u8Url) throws IOException {
        String fileName = "C:\\Users\\doyou\\Downloads\\streaming.m3u8";
        try {
            m3u8Url = m3u8Url.replaceFirst("&","?");
            m3u8Url = m3u8Url.replaceFirst("M3U8_AUTO_480","M3U8_AUTO_1080");
            URL url = new URL(m3u8Url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            fileName = "C:\\Users\\doyou\\Downloads\\streaming"+new Date().getTime()+".m3u8";
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            InputStream inputStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
            inputStream.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        Resource resource = new FileSystemResource(fileName);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
