package com.course.ro.section6.model.dto;

import com.course.ro.section6.model.dto.validation.annotation.ListNotEmpty;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyDTO {

    private Long id;
//    private int version;

    @NotNull(message = "cannot be null")
    @Size(min=1, message = "is required")
    @Size(max=10, message = "must not exceed 10 characters")
    private String name;

    @Pattern(regexp = "^(https?:\\/\\/)?(www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$", message = "invalid URL")
    private String websiteUrl;
    private String country;
    private boolean isActive = true;

    @ListNotEmpty
    private List<String> industryList = new ArrayList<>();
    private String industry;

    @Min(value=1, message="must have at least one employee")
    @Max(value=10000, message="{Max.company.numberOfEmployees}")
    private Integer numberOfEmployees;

    public CompanyDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public int getVersion() {
//        return version;
//    }
//
//    public void setVersion(int version) {
//        this.version = version;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<String> getIndustryList() {
        return industryList;
    }

    public void setIndustryList(List<String> industryList) {
        this.industryList = industryList;
        this.industry = StringUtils.join(industryList, ",");
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
        this.industryList = industry != null ? Arrays.stream(industry.split(",")).collect(Collectors.toList()) : Collections.emptyList();
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
//                ", version=" + version +
                ", name='" + name + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", country='" + country + '\'' +
                ", isActive=" + isActive +
                ", numberOfEmployees=" + numberOfEmployees +
                ", industry=" + Arrays.toString(industryList.toArray()) +
                '}';
    }
}
