package com.course.ro.section6.model.dao;

import com.course.ro.section6.model.entity.Company;

import java.util.List;
import java.util.Optional;

public interface ICompanyDAO {

    Company save(Company company);
    Optional<Company> findById(Long id);
    List<Company> findAll();
    List<Company> findByName(String name);
    void deleteById(Long id);

    List<Company> findAllByOrderByNameAsc();
}
