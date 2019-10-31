package com.home.haxul.restapi.controllers;

import com.home.haxul.restapi.dto.User;
import com.home.haxul.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {
    private HashMap<String, User> store = new HashMap<>();

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{userId}")
    public ResponseEntity<User> getPage(@PathVariable String userId) {
        User user = (User) store.get(userId);
        if (user != null) return new ResponseEntity<User>(user, HttpStatus.OK);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public String getPage(@RequestParam(value = "limit") int limit, @RequestParam(value = "page", defaultValue = "200") int page) {
        return "page: " + page + " ==> " + " limit " + limit;
    }

    @GetMapping(value = "/some")
    public ResponseEntity<User> getPage() {
        User user = new User();
        user.setEmail("starodubov@yandex.ru");
        user.setPassword("123");
        user.setLastname("starodubov");
        user.setName("sergey");
        return new ResponseEntity<User>(user, HttpStatus.valueOf(201));
    }

    @PostMapping
    public ResponseEntity<User> getUser(@Valid @RequestBody User user) {
        User account = userService.createUser(user);
        return new ResponseEntity<User>(account, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User account = store.get(id);
        if (account == null) return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        if (user.getEmail() != null) account.setEmail(user.getEmail());
        if (user.getLastname() != null) account.setLastname(user.getLastname());
        if (user.getPassword() != null) account.setPassword(user.getPassword());
        if (user.getName() != null) account.setName(user.getName());
        return new ResponseEntity<User>(account, HttpStatus.OK);
    }
}
