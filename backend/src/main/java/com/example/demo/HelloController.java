package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @CrossOrigin(origins = "https://d2exsd50zeg79m.cloudfront.net")
    @GetMapping("/hello")
    public String hello() {
        return "Hello from the backend!";
    }
}

