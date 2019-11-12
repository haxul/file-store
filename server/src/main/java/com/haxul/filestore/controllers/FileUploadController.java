package com.haxul.filestore.controllers;

import com.haxul.filestore.dto.FileUploadDto;
import com.haxul.filestore.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/files/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<String> uploadMultipleFiles(@Valid @ModelAttribute("fileUploadDto") FileUploadDto inputFiles, Authentication authentication) throws IOException {
        String username = authentication.getName();
        fileUploadService.uploadFile(inputFiles, username);
        return new ResponseEntity("Files have bees successfully uploaded", HttpStatus.OK);
    }
}
