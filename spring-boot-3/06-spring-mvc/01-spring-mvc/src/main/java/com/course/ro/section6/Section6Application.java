package com.course.ro.section6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Section6Application {

	public static void main(String[] args) {
		SpringApplication.run(Section6Application.class, args);
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
