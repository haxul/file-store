package com.home.haxul.restapi.services;

import com.home.haxul.restapi.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UserService {

    private Utils utils;

    public UserService() {}

    @Autowired
    public UserService(Utils utils) {
        this.utils = utils;
    }
    private HashMap<String, User> storage = new HashMap<>();

    public User createUser(User user) {
        User account = new User();
        account.setName(user.getName());
        account.setLastname(user.getLastname());
        account.setPassword(user.getPassword());
        account.setEmail(user.getEmail());
        String uid = utils.generateId();
        account.setId(uid);
        storage.put(uid, account);
        return account;
    }
}
