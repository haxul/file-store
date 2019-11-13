package com.haxul.filestore.controllers;

import com.haxul.filestore.dao.FileDao;
import com.haxul.filestore.dao.FilePaginationDao;
import com.haxul.filestore.dao.UserDao;
import com.haxul.filestore.dto.FilesDtoResponse;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")

public class FilesController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private FilePaginationDao filePaginationDao;

    @GetMapping("/user")
    @Transactional
    public ResponseEntity<?> getAllUserFiles(Authentication authentication, @RequestParam Integer page) {
        if (page < 0) return new ResponseEntity("param page must be more or equal than 0",HttpStatus.BAD_REQUEST);
        String username = authentication.getName();
        UserEntity user = userDao.findUserEntityByUsername(username);
        int userId = user.getId();
        List<FilesDtoResponse> files = filePaginationDao.findFileEntitiesByUserEntity_Id(userId , PageRequest.of(page, 5, Sort.by("created").descending()))
                .stream().map(file -> new FilesDtoResponse(file.getId(), file.getTitle(), file.getPath(), file.getCreated(), file.isFavorites()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(files);
    }
}
