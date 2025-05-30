package com.course.ro.section4.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends JPAEntity {

    @Column(name="name")
    private String name;

    @Column(name="website_url")
    private String websiteUrl;

    public Company() {
    }

    public Company(String name, String websiteUrl) {
        this.name = name;
        this.websiteUrl = websiteUrl;
    }

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

    @Override
    public String toString() {
        return "Company{" +
                "id='" + getId() + '\'' +
                ", version='" + getVersion() + '\'' +
                ", name='" + name + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                '}';
    }
}
