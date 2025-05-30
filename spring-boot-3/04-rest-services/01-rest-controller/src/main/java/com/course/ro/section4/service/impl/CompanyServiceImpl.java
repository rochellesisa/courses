package com.course.ro.section4.service.impl;

import com.course.ro.section4.model.dao.ICompanyDAO;
import com.course.ro.section4.model.entity.Company;
import com.course.ro.section4.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
public class CompanyServiceImpl implements ICompanyService {

    private final ICompanyDAO companyRepo;

    @Autowired
    public CompanyServiceImpl(ICompanyDAO companyRepo) {
        this.companyRepo = companyRepo;
    }


    @Override
    public List<Company> getAll() {
        return companyRepo.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepo.findById(id);
    }

    @Override
    @Transactional
    public Company create(Company company) {
        companyRepo.save(company);
        return company;
    }

    @Override
    @Transactional
    public Company update(Company incoming) {
        Company orig = companyRepo.findById(incoming.getId());
        orig.setName(incoming.getName());
        orig.setWebsiteUrl(incoming.getWebsiteUrl());
        return companyRepo.update(orig);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        companyRepo.delete(id);
    }

    @Override
    public List<Company> findByName(String name) {
        return companyRepo.findByName(name);
    }
}
