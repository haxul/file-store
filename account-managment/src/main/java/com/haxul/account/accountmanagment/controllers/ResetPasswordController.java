package com.haxul.account.accountmanagment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reset")
public class ResetPasswordController {

    @GetMapping("/password")
    public String resetPassword() {
        return "reset password...";
    }
}
