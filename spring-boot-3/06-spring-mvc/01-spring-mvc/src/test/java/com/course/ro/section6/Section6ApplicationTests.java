package com.course.ro.section6;

import com.course.ro.section6.model.dto.converter.MapstructMapper;
import com.course.ro.section6.model.entity.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Section6ApplicationTests {

	@Autowired
	private MapstructMapper mapper;

	@Test
	void contextLoads() {
		Company c = new Company();
		c.setId(5L);
		c.setName("LKJJ");
		c.setWebsiteUrl("ABC.com");

		System.out.println(mapper.companyDTOToCompany(c));
	}

}
