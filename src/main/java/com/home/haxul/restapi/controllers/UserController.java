package com.home.haxul.restapi.controllers;

import org.springframework.web.bind.annotation.*;

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
}
