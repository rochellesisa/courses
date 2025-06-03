package com.course.ro.section5.model.dao;

import com.course.ro.section5.model.entity.Company;

import java.util.List;

public interface ICompanyDAO {

    void save(Company company);
    Company findById(Long id);
    List<Company> findAll();
    List<Company> findByName(String name);
    Company update(Company company);
    int updateWebsite(Long id, String url);

    int deleteByName(String name);
    void delete(Long id);
}
