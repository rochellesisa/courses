package com.course.ro.section5.service;

import com.course.ro.section5.model.entity.Company;

import java.util.List;

public interface ICompanyService {

    List<Company> getAll();

    Company getById(Long id);

    Company create(Company company);

    Company update(Company incoming);

    void delete(Long id);

    List<Company> findByName(String name);
}
