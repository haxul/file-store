package com.haxul.filestore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class RedirectController {

    @GetMapping("/login")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

    @GetMapping("/signup")
    public void getMainPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

}
