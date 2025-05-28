package com.courses.ro.section1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 @RestController
public class FunRestController {

    private String hello;

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/eh")
    public String sayHelloMhie(){
        return "Hello Bhie!";
    }

}
