package com.pigo.shop.controller;

import com.pigo.shop.common.APIResponse;
import com.pigo.shop.common.ResponeCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @Author: lin
 * @Date: 2024/02/02/15:44
 * @Description: None
 */
@RestController
@RequestMapping("/staticfiles")
public class StaticfilesController {
    @Value("${File.uploadPath}")
    private String filePath;

    @RequestMapping(value = "/image/{cover}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("cover") String cover) throws IOException {
        String fullFilePath = getFullFilePath("image", cover);
        return getFileResponse(fullFilePath);
    }

    @RequestMapping(value = "/avatar/{cover}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getAvatar(@PathVariable("cover") String cover) throws IOException {
        String fullFilePath = getFullFilePath("avatar", cover);
        return getFileResponse(fullFilePath);
    }

    private String getFullFilePath(String folder, String cover) {
        return System.getProperty("user.dir") + filePath + File.separator + folder + File.separator + cover;
    }
    private ResponseEntity<byte[]> getFileResponse(String fullFilePath) throws IOException {
        File file = new File(fullFilePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fis.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(bytes.length);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
