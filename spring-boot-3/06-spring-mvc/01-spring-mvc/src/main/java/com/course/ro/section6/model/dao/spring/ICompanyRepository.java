package com.course.ro.section6.model.dao.spring;

import com.course.ro.section6.model.dao.ICompanyDAO;
import com.course.ro.section6.model.entity.Company;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "companye")
@RepositoryRestResource(exported = false)
@Primary
public interface ICompanyRepository extends JpaRepository<Company, Long>, ICompanyDAO {

    @Query("SELECT COUNT(o) FROM Company o WHERE o.name LIKE CONCAT(:name, '%') ")
    int countAll(@Param("name") String name);

    List<Company> findAllByOrderByNameAsc();

}
