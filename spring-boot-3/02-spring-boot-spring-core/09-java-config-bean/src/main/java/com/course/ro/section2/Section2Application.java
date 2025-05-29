package com.course.ro.section2;

import com.course.ro.section2.configuration.MessageParserConfig;
import com.course.ro.section2.configuration.MessageParserConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication (scanBasePackages = {
		"com.course.ro.section2",
		"com.course.ro.commons"})
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MessageParserConfig2.class)})
public class Section2Application {

	public static void main(String[] args) {
		SpringApplication.run(Section2Application.class, args);
	}

}
