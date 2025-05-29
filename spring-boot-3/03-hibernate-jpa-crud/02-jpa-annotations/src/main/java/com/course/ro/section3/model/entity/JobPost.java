package com.course.ro.section3.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

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
