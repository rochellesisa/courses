package com.course.ro.section5.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_post")
public class JobPost extends JPAEntity {

    @Column(name="role")
    private String role;

//    @Column(name="date_posted")
//    private Date datePosted;
//
//    @Column(name="date_expiry")
//    private Date dateExpiry;

    public String getRole() {
        return role;
    }
}
