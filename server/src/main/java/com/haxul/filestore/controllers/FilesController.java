package com.haxul.filestore.controllers;

import com.haxul.filestore.dao.FileDao;
import com.haxul.filestore.dao.UserDao;
import com.haxul.filestore.dto.UserDto;
import com.haxul.filestore.models.FileEntity;
import com.haxul.filestore.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FilesController {

    @Autowired
    private FileDao fileDao;

    @Autowired
    private UserDao userDao;

    @GetMapping("/user")
    public ResponseEntity<?> getAllUserFiles(Authentication authentication, @RequestParam(required = false) Integer step) {

        String username = authentication.getName();
        UserEntity user = userDao.findUserEntityByUsername(username);
        List<FileEntity> files = fileDao.findFileEntitiesByUserEntity_IdOrderByCreatedDesc(user.getId(), PageRequest.of(1,1));

        return ResponseEntity.ok().header("content-type", "application/json").body(files);
    }
}
