package com.portfolio.SpringBoot.Project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
    public List<String> helloController(){
        return List.of(welcomeMessage);
    }
}
