package com.haxul.filestore.controllers;

import com.haxul.filestore.dao.FileDao;
import com.haxul.filestore.models.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/files/{id}/download")
public class FileDownloadController {

    @Autowired
    private FileDao fileDao;

    @GetMapping
    public ResponseEntity<?> downloadFile(@PathVariable int id) throws FileNotFoundException {
        FileEntity file = fileDao.findFileEntityById(id);
        if (file == null) return new ResponseEntity("File is not found", HttpStatus.UNPROCESSABLE_ENTITY);

        String path = file.getPath();

        File fileToDownload = new File(path);
        HttpHeaders headers = new HttpHeaders();

        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("filename", file.getTitle());

        InputStreamResource resource = new InputStreamResource(new FileInputStream(fileToDownload));
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileToDownload.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);

    }
}
