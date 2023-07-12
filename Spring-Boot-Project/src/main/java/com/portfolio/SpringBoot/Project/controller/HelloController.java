package com.portfolio.SpringBoot.Project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/")
    public List<String> helloController(){
        return List.of("This is my second Project!!!", "So what duhh !");
    }
}
