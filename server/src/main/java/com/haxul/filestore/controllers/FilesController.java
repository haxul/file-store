package com.haxul.filestore.controllers;

import com.haxul.filestore.dao.FileDao;
import com.haxul.filestore.dto.UserDto;
import com.haxul.filestore.models.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FilesController {

    @Autowired
    private FileDao fileDao;

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllUserFiles(@PathVariable int userId) {
        List<FileEntity> files = fileDao.findFileEntitiesByUserEntityId(userId);
        if (files == null) return new ResponseEntity("Files are not found", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().header("content-type", "application/json").body(files);
    }
}
