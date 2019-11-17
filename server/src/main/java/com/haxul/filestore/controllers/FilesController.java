package com.haxul.filestore.controllers;

import com.haxul.filestore.dao.FileDao;
import com.haxul.filestore.dao.FilePaginationDao;
import com.haxul.filestore.dao.UserDao;
import com.haxul.filestore.dto.FilesDtoResponse;
import com.haxul.filestore.dto.PutRequestDto;
import com.haxul.filestore.dto.UserDto;
import com.haxul.filestore.models.FileEntity;
import com.haxul.filestore.models.UserEntity;
import com.haxul.filestore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")

public class FilesController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private FilePaginationDao filePaginationDao;

    @Autowired
    private UserService userService;

    @Autowired
    private FileDao fileDao;

    @GetMapping("/user")
    @Transactional
    public ResponseEntity<?> getAllUserFiles(Authentication authentication, @RequestParam Integer page) {
        if (page < 0) return new ResponseEntity("param page must be more or equal than 0", HttpStatus.BAD_REQUEST);
        String username = authentication.getName();
        UserEntity user = userDao.findUserEntityByUsername(username);
        int userId = user.getId();
        List<FilesDtoResponse> files = filePaginationDao.findFileEntitiesByUserEntity_Id(userId, PageRequest.of(page, 5, Sort.by("created").descending()))
                .stream().map(file -> new FilesDtoResponse(file.getId(), file.getTitle(), file.getPath(), file.getCreated(), file.isFavorites()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(files);
    }

    @GetMapping("/search")
    @Transactional
    public ResponseEntity<?> findFilesByPattern(Authentication authentication, @RequestParam String title) {
        Pattern pattern = Pattern.compile("[<>/\\.\\-\"']");
        Matcher matcher = pattern.matcher(title);
        if (matcher.find()) return ResponseEntity.badRequest().body("Incorrect input data");
        UserEntity currentUser = userService.getAuthorizatedUser(authentication);
        int userId = currentUser.getId();
        List<FilesDtoResponse> files = fileDao.findFileEntitiesByTitleStartingWithAndUserEntity_Id(title, userId).stream()
                .map(file -> new FilesDtoResponse(file.getId(), file.getTitle(), file.getPath(), file.getCreated(), file.isFavorites()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(files);
    }

    @DeleteMapping("/{fileId}")
    @Transactional
    public ResponseEntity<?> removeFile(@PathVariable int fileId, Authentication authentication) {
        UserEntity user = userDao.findUserEntityByUsername(authentication.getName());
        FileEntity file = fileDao.findFileEntityByIdAndUserEntity_Id(fileId, user.getId());
        if (file == null) return ResponseEntity.badRequest().body("File is not found");
        List<FileEntity> userFiles = user.getFileEntities().stream().filter(userFile -> userFile.getId() != file.getId()).collect(Collectors.toList());
        user.setFileEntities(userFiles);
        fileDao.deleteById(file.getId());
        return ResponseEntity.ok().body("The file is removed");
    }

    @PutMapping("/{fileId}")
    @Transactional
    public ResponseEntity<?> updateFile(@PathVariable int fileId, Authentication authentication,@Valid @RequestBody PutRequestDto fields) {
        UserEntity user = userDao.findUserEntityByUsername(authentication.getName());
        FileEntity file = fileDao.findFileEntityByIdAndUserEntity_Id(fileId, user.getId());
        if (file == null) return ResponseEntity.badRequest().body("File is not found");
        if (fields.getIsPopular() != null) file.setFavorites(fields.getIsPopular());
        if (fields.getTitle() != null) file.setTitle(fields.getTitle());
        return ResponseEntity.ok().body("file: " + fileId + " has been successfully updated");
    }
}
