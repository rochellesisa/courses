//package com.course.ro.section6.service.impl;
//
//import com.course.ro.section6.model.dto.CompanyDTO;
//import com.course.ro.section6.model.dto.mapstruct.MapstructMapper;
//import com.course.ro.section6.model.entity.Company;
//import com.course.ro.section6.model.dao.spring.ICompanyRepository;
//import com.course.ro.section6.service.ICompanyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class CompanyServiceJpaRepoImpl implements ICompanyService {
//
//    private final ICompanyDAO companyRepo;
//    private final MapstructMapper mapper;
//
//    @Autowired
//    public CompanyServiceJpaRepoImpl(ICompanyDAO companyRepo, MapstructMapper mapper) {
//        this.companyRepo = companyRepo;
//        this.mapper = mapper;
//    }
//
//
//    @Override
//    public List<CompanyDTO> getAll() {
//        return companyRepo.findAll().stream().map(c -> mapper.companyToCompanyDTO(c)).collect(Collectors.toList());
//    }
//
//    @Override
//    public CompanyDTO getById(Long id) {
//        return mapper.companyToCompanyDTO(companyRepo.findById(id).orElse(null));
//    }
//
//    @Override
//    @Transactional
//    public CompanyDTO create(CompanyDTO companyDto) {
//        Company company = mapper.companyDTOToCompany(companyDto);
//        companyRepo.save(company);
//        return mapper.companyToCompanyDTO(company);
//    }
//
//    @Override
//    @Transactional
//    public CompanyDTO update(CompanyDTO incoming) {
//        Company orig = companyRepo.findById(incoming.getId()).get();
//        orig.setName(incoming.getName());
//        orig.setWebsiteUrl(incoming.getWebsiteUrl());
//        return mapper.companyToCompanyDTO(companyRepo.save(orig));
//    }
//
//    @Override
//    @Transactional
//    public void delete(Long id) {
//        companyRepo.deleteById(id);
//    }
//
//    @Override
//    public List<CompanyDTO> findByName(String name) {
//        return companyRepo.findByName(name).stream().map(c -> mapper.companyToCompanyDTO(c)).collect(Collectors.toList());
//    }
//}
