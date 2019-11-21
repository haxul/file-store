package com.haxul.filestore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class CheckTokenController {

    @GetMapping
    public ResponseEntity<?> checkToken(Authentication authentication) {
        boolean isAuthenticated = authentication.isAuthenticated();
        HttpStatus httpStatus = isAuthenticated? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return  new ResponseEntity(httpStatus);
    }
}
