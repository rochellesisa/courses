package com.course.ro.section2.controller;

import com.course.ro.commons.SomeUtilService;
import com.course.ro.section2.service.MessageParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageParser parser;
    private final SomeUtilService util;
    @Autowired
    public MessageController(@Qualifier("skypeMessageParser") MessageParser parser, SomeUtilService util) {
        this.parser = parser;
        this.util = util;
    }

    @GetMapping("/")
    public String parse(){
        parser.parseMessage(null);
        util.print();
        return parser.getClass().toString();
    }
}
