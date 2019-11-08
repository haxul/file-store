package com.haxul.filestore;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootApplication
public class FileStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileStoreApplication.class, args);
    }


}
