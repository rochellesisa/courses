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

    @GetMapping("/bye")
    public String sayBye(){
        return "Goodbye World!";
    }

    @GetMapping("/nyeah")
    public String sayNyeahhhh(){
        return "Nyeaaahhhh";
    }
 }
