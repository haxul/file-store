package com.haxul.applicationuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationuserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationuserApplication.class, args);
    }

}
