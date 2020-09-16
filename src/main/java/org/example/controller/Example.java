package org.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
class Example {

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}

@RestController
class HelloController {

    @RequestMapping("/")
    public String hello()
    {
        return "Hello Spring Booot";
    }

}

