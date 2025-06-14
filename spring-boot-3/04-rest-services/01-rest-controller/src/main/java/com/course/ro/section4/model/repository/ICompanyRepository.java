package com.course.ro.section4.model.repository;

import com.course.ro.section4.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

//@RepositoryRestResource(path = "companye")
//@RepositoryRestResource(exported = false, path = "companye")
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
