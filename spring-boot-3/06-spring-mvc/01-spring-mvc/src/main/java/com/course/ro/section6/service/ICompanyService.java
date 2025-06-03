package com.course.ro.section6.service;

import com.course.ro.section6.model.dto.CompanyDTO;
import com.course.ro.section6.model.entity.Company;

import java.util.List;

public interface ICompanyService {

    List<CompanyDTO> getAll();

    CompanyDTO getById(Long id);

    CompanyDTO create(CompanyDTO company);

    CompanyDTO update(CompanyDTO incoming);

    void delete(Long id);

    List<CompanyDTO> findByName(String name);
}
