package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendSpringApplication  {
    @Autowired
    //ssUserRepository ob;
    public static void main(String[] args) {

        SpringApplication.run(BackendSpringApplication.class, args);
    }



}

