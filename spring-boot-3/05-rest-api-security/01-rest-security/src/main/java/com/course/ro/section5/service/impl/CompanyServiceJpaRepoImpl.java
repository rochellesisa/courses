package com.course.ro.section5.service.impl;

import com.course.ro.section5.model.entity.Company;
import com.course.ro.section5.model.repository.ICompanyRepository;
import com.course.ro.section5.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceJpaRepoImpl implements ICompanyService {

    private final ICompanyRepository companyRepo;

    @Autowired
    public CompanyServiceJpaRepoImpl(ICompanyRepository companyRepo) {
        this.companyRepo = companyRepo;
    }


    @Override
    public List<Company> getAll() {
        return companyRepo.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepo.findById(id).orElse(null);
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
        Company orig = companyRepo.findById(incoming.getId()).get();
        orig.setName(incoming.getName());
        orig.setWebsiteUrl(incoming.getWebsiteUrl());
        return companyRepo.save(orig);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        companyRepo.deleteById(id);
    }

    @Override
    public List<Company> findByName(String name) {
        return companyRepo.findByName(name);
    }
}
