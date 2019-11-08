package com.haxul.filestore.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull
    @Length(min = 3)
    @UniqueElements
    private String username;

    @UniqueElements
    @Length(min = 6)
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}