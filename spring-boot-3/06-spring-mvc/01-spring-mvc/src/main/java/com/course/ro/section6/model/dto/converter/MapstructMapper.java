package com.course.ro.section6.model.dto.converter;

import com.course.ro.section6.model.dto.CompanyDTO;
import com.course.ro.section6.model.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapstructMapper {

    CompanyDTO companyToCompanyDTO(Company company);

    Company companyDTOToCompany(CompanyDTO company);

}
