package com.haxul.filestore.services;

import com.haxul.filestore.dao.UserDao;
import com.haxul.filestore.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserEntity getAuthorizatedUser(Authentication authentication) {
        String username = authentication.getName();
        UserEntity user = userDao.findUserEntityByUsername(username);
        return user;
    }
}
