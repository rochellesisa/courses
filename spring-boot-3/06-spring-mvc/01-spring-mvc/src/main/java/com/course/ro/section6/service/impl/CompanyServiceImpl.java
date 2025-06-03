package com.course.ro.section6.service.impl;

import com.course.ro.section6.model.dao.ICompanyDAO;
import com.course.ro.section6.model.dto.CompanyDTO;
import com.course.ro.section6.model.dto.converter.MapstructMapper;
import com.course.ro.section6.model.entity.Company;
import com.course.ro.section6.service.ICompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class CompanyServiceImpl implements ICompanyService {

    private final ICompanyDAO companyRepo;
    private final MapstructMapper mapper;
    private final ObjectMapper objectMapper;


    @Autowired
    public CompanyServiceImpl(ICompanyDAO companyRepo, MapstructMapper mapper, ObjectMapper objectMapper) {
        this.companyRepo = companyRepo;
        this.mapper = mapper;
        this.objectMapper = objectMapper;
    }


    @Override
    public List<CompanyDTO> getAll() {
        return companyRepo.findAllByOrderByNameAsc().stream().map(c -> mapper.companyToCompanyDTO(c)).collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getById(Long id) {
        return  mapper.companyToCompanyDTO(companyRepo.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public CompanyDTO create(CompanyDTO companyDto) {
        Company company = mapper.companyDTOToCompany(companyDto);
        companyRepo.save(company);
        return mapper.companyToCompanyDTO(company);
    }

    @Override
    @Transactional
    public CompanyDTO update(CompanyDTO incoming) {
        Company orig = companyRepo.findById(incoming.getId()).get();
        Company update = apply(orig, mapper.companyDTOToCompany(incoming));
        update.setVersion(orig.getVersion());
        return mapper.companyToCompanyDTO(companyRepo.save(update));
    }

    private Company apply(Company orig, Company incoming){
        ObjectNode companyNode = objectMapper.convertValue(orig, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(incoming, ObjectNode.class);

        companyNode.setAll(patchNode);
        return objectMapper.convertValue(companyNode, Company.class);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        companyRepo.deleteById(id);
    }

    @Override
    public List<CompanyDTO> findByName(String name) {
        return companyRepo.findByName(name).stream().map(c -> mapper.companyToCompanyDTO(c)).collect(Collectors.toList());
    }
}
