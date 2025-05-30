package com.course.ro.section4.model.repository;

import com.course.ro.section4.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "companye")
public interface ICompanyRepository extends JpaRepository<Company, Long> {

//    @Query("FROM Company o WHERE o.name=:name")
    List<Company> findByName(@Param("name") String name);
}
