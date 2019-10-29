package com.home.haxul.restapi.controllers;

import com.home.haxul.restapi.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path = "/{userId}")
    public String getPage(@PathVariable String userId) {
        return userId;
    }

    @GetMapping
    public String getPage(@RequestParam(value = "limit") int limit, @RequestParam(value = "page", defaultValue = "200") int page) {
        return "page: " + page + " ==> " + " limit " + limit;
    }

    @GetMapping(value = "/some")
    public ResponseEntity<User> getPage() {
        User user = new User();
        user.setAge(28);
        user.setLastname("starodubov");
        user.setName("sergey");
        return new ResponseEntity<User>(user, HttpStatus.valueOf(201));
    }

    @PostMapping
    public ResponseEntity<User> getUser(@RequestBody User user) {
        User account = new User();
        account.setName(user.getName());
        account.setLastname(user.getLastname());
        account.setAge(user.getAge());
        return new ResponseEntity<User>(account, HttpStatus.OK);
    }
}
