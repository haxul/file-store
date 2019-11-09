package com.haxul.filestore.controllers;

import com.haxul.filestore.dto.FileUploadDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/files/upload")
public class FileUploadController {

    private static final String UPLOADED_FOLDER = "/home/haxul/IdeaProjects/file-store/server/upload/";

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadMultipleFiles(@Valid @ModelAttribute("fileUploadDto") FileUploadDto inputFiles) {

        try {
            File dir = new File(UPLOADED_FOLDER);
            MultipartFile[] files = inputFiles.getFiles();
            for (MultipartFile file : files) {
                byte[] bytes = file.getBytes();
                if (!dir.exists()) dir.mkdirs();
                File uploadFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
                outputStream.write(bytes);
                outputStream.close();
            }
        } catch (Exception error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Files are not uploaded. Reason: " + error.getMessage());
        }
        return new ResponseEntity("Files have bees successfully uploaded", HttpStatus.OK);
    }
}
