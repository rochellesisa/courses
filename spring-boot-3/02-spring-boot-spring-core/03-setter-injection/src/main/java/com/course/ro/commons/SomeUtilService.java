package com.course.ro.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeUtilService {

    @Autowired
    private TestService test;

    public void print(){
        System.out.println("HEYYYYYY");
    }
}
