package com.course.ro.section4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Section4Application {

	public static void main(String[] args) {
		SpringApplication.run(Section4Application.class, args);
	}

//	@Bean
//	@Transactional
//	public CommandLineRunner commandLineRunner(CompanyDAO dao) {
//		return r -> {
//			Company c = new Company("TEST", "test.com");
//			dao.save(c);
//			System.out.println(c);
//			dao.delete(c.getId());
//		};
//	}
}
