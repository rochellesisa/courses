package com.course.ro.section2.service.impl;

import com.course.ro.section2.model.Metadata;
import com.course.ro.section2.service.MessageParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SkypeMessageParser implements MessageParser {

    public SkypeMessageParser() {
        System.out.println("INIT::::" + this.getClass().getSimpleName());
    }

    @Override
    public void parseMessage(Metadata metadata) {
        System.out.println("Parse for Skype");
    }
}