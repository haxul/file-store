package com.haxul.filestore.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Test {

    @GetMapping
    public String test(Authentication authentication) {
        String username = authentication.getName();
        return username;
    }
}
