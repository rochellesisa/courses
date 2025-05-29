package com.course.ro.section2.service.impl;

import com.course.ro.section2.model.Metadata;
import com.course.ro.section2.service.MessageParser;
import org.springframework.stereotype.Component;

@Component
public class ViberMessageParser implements MessageParser {

    @Override
    public void parseMessage(Metadata metadata) {
        System.out.println("Parse for Viber");
    }
}