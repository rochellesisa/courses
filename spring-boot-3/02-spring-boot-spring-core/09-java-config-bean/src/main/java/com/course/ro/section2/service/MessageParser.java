package com.course.ro.section2.service;

import com.course.ro.section2.model.Metadata;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;


public interface MessageParser {

    void parseMessage(Metadata metadata);

}
