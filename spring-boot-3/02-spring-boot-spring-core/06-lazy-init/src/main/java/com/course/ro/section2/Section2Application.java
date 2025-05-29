package com.course.ro.section2;

import com.course.ro.commons.SomeUtilService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {
		"com.course.ro.section2",
		"com.course.ro.commons"})
public class Section2Application {

	public static void main(String[] args) {
		SpringApplication.run(Section2Application.class, args);
	}

}
