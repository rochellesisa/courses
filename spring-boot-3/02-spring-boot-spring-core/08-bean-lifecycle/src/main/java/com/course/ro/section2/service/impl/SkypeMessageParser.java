package com.course.ro.section2.service.impl;

import com.course.ro.section2.model.Metadata;
import com.course.ro.section2.service.MessageParser;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SkypeMessageParser implements MessageParser {

    public SkypeMessageParser() {
        System.out.println("INIT::::" + this.getClass().getSimpleName());
    }

    @PostConstruct
    public void init(){
        System.out.println("POST CONSTRUCT");
    }

    @PreDestroy
    public void dest(){
        System.out.println("DESTROYING");
    }


    @Override
    public void parseMessage(Metadata metadata) {
        System.out.println("Parse for Skype");
    }
}