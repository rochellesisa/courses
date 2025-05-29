package com.course.ro.section3.model.dao.impl;

import com.course.ro.section3.model.dao.CompanyDAO;
import com.course.ro.section3.model.entity.Company;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    private EntityManager em;

    @Autowired
    public CompanyDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Company company) {
        em.persist(company);
    }

    @Override
    public Company findById(Long id) {
        return em.find(Company.class, id);
    }

    @Override
    public List<Company> findAll() {
        return em.createQuery("FROM Company o ORDER BY name", Company.class).getResultList();
    }

    @Override
    public List<Company> findByName(String name) {
        return em.createQuery("FROM Company WHERE name=:name", Company.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    @Transactional
    public Company update(Company company) {
        return em.merge(company);
    }

    @Override
    @Transactional
    public int updateWebsite(Long id, String url) {
        return em.createQuery("UPDATE Company SET websiteUrl=:url WHERE id=:id")
                .setParameter("url", url)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Company c = em.find(Company.class, id);
        em.remove(c);
    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        return em.createQuery("DELETE FROM Company WHERE name=:name")
                .setParameter("name", name)
                .executeUpdate();
    }

}
