package com.course.ro.section4;

import com.course.ro.section4.model.dao.CompanyDAO;
import com.course.ro.section4.model.entity.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Section4Application {

	public static void main(String[] args) {
		SpringApplication.run(Section4Application.class, args);
	}

//	CREATE
//	@Bean
//	public CommandLineRunner commandLineRunner(CompanyDAO dao){
//		return r -> {
//
//			Company comp1 = new Company("CBTW", "cbtw.com");
//			Company comp2 = new Company("GCash", "gcash.com");
//			Company comp3 = new Company("WAES", "waes.com");
//			dao.save(comp1);
//			dao.save(comp2);
//			dao.save(comp3);
//			System.out.println(comp1);
//			System.out.println(comp2);
//			System.out.println(comp3);
//		};
//	}

//	READ
//	@Bean
//	public CommandLineRunner commandLineRunner(CompanyDAO dao){
//		return r -> {
//			System.out.println(dao.findById(2L));
//			System.out.println(dao.findById(4L));
//			System.out.println(dao.findById(5L));
//			System.out.println(dao.findAll());
//			System.out.println(dao.findByName("WAES"));
//		};
//	}

//	UPDATE
//	@Bean
//	public CommandLineRunner commandLineRunner(CompanyDAO dao){
//		return r -> {
//			Company com = dao.findById(2L);
//			System.out.println("Current: " + com);
//			com.setWebsiteUrl("maya.com.ph");
//			com = dao.update(com);
//			System.out.println(com);
//
//
//			System.out.println("Current: " + dao.findById(1L));
//			dao.updateWebsite(1L, "hello.com");
//			System.out.println("Updated2: " + dao.findById(1L));
//
//		};
//	}

	@Bean
	@Transactional
	public CommandLineRunner commandLineRunner(CompanyDAO dao) {
		return r -> {
			Company c = new Company("TEST", "test.com");
			dao.save(c);
			System.out.println(c);
			dao.delete(c.getId());
		};
	}
}
