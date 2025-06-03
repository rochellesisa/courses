package com.course.ro.section5.model.repository;

import com.course.ro.section5.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "companye")
@RepositoryRestResource(exported = false)
public interface ICompanyRepository extends JpaRepository<Company, Long> {

//    @Query("FROM Company o WHERE o.name=:name")
    List<Company> findByName(@Param("name") String name);

    @Query("SELECT COUNT(o) FROM Company o WHERE o.name LIKE CONCAT(:name, '%') ")
    int countAll(@Param("name") String name);
//    @Override
//    @RestResource(exported = false)
//    void deleteById(Long id);
//
//    @Override
//    @RestResource(exported = false)
//    Company save(Company company);
}
