package com.course.ro.section2.service.impl;

import com.course.ro.section2.model.Metadata;
import com.course.ro.section2.service.MessageParser;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class WhatsappMessageParser implements MessageParser {

    public WhatsappMessageParser() {
        System.out.println("INIT::::" + this.getClass().getSimpleName());
    }

    @Override
    public void parseMessage(Metadata metadata) {
        System.out.println("Parse for Whatsapp");
    }
}
