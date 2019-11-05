package com.haxul.applicationuser.controllers;

import com.haxul.applicationuser.entities.UserEntity;
import com.haxul.applicationuser.models.User;
import com.haxul.applicationuser.services.UserService;
import com.haxul.applicationuser.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @GetMapping("/status/check")
    public String status() {
        return "application works on " + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@Valid @RequestBody User user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userdto = modelMapper.map(user, UserDto.class);
        userService.createUser(userdto);

        return "new user is created";
    }
}
