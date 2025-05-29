package com.course.ro.section2.controller;

import com.course.ro.commons.SomeUtilService;
import com.course.ro.section2.service.MessageParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageParser parser;
    private SomeUtilService util;

    @Autowired
    public MessageController(@Qualifier("skypeMessageParser") MessageParser parser) {
        this.parser = parser;
    }

    @GetMapping("/")
    public String parse(){
        parser.parseMessage(null);
        return util == null ? "UTIL IS NULL" : "UTIL IS NOT NULL";
//        return parser.getClass().toString();
    }

    @Autowired(required = false)
    public void setUtil(SomeUtilService util){
        this.util = util;
    }
}
