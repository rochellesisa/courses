//package com.course.ro.section6.model.dao.impl;
//
//import com.course.ro.section6.model.dao.ICompanyDAO;
//import com.course.ro.section6.model.entity.Company;
//import jakarta.persistence.EntityManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class CompanyDAOImpl implements ICompanyDAO {
//
//    private EntityManager em;
//
//    @Autowired
//    public CompanyDAOImpl(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    @Transactional
//    public Company save(Company company) {
//        if (company.getId() == null)
//            em.persist(company);
//        else
//            company = em.merge(company);
//
//        return company;
//    }
//
//    @Override
//    public Optional<Company> findById(Long id) {
//        return Optional.of(em.find(Company.class, id));
//    }
//
//    @Override
//    public List<Company> findAll() {
//        return em.createQuery("FROM Company o ORDER BY name", Company.class).getResultList();
//    }
//
//    @Override
//    public List<Company> findByName(String name) {
//        return em.createQuery("FROM Company WHERE name=:name", Company.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(Long id) {
//        Company c = em.find(Company.class, id);
//        em.remove(c);
//    }
//
//
//}
