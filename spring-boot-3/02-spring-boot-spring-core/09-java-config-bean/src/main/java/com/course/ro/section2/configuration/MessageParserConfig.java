package com.course.ro.section2.configuration;

import com.course.ro.section2.service.MessageParser;
import com.course.ro.section2.service.impl.YahooMessageParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageParserConfig {

    @Bean(name = {"yahooMessenger", "yahooMassage"})
    public MessageParser ymParser(){
        return new YahooMessageParser();
    }

}
