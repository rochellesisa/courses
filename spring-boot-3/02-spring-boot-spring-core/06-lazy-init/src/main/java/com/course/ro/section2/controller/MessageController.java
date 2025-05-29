package com.course.ro.section2.controller;

import com.course.ro.section2.service.MessageParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class MessageController {

    private final MessageParser parser;

    @Autowired
    public MessageController(@Qualifier("skypeMessageParser") MessageParser parser) {
        this.parser = parser;
    }

    @GetMapping("/")
    public String parse(){
        parser.parseMessage(null);
        return parser.getClass().toString();
    }

}
