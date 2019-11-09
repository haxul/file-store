package com.haxul.filestore.security;
import java.util.ArrayList;

import com.haxul.filestore.dao.UserDao;
import com.haxul.filestore.dto.UserDto;
import com.haxul.filestore.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity currentUser = userDao.findUserEntityByUsername(username);
        String currentUserUsername = currentUser.getUsername();
        String currentUserPassword = currentUser.getPassword();
         if (currentUserUsername.equals(username)) {
            return new User(currentUserUsername, currentUserPassword,
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserEntity save(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(userEntity);
    }
}
