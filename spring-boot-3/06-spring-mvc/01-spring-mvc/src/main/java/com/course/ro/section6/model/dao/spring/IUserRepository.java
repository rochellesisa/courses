package com.course.ro.section6.model.dao.spring;

import com.course.ro.section6.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(@Param("username") String username);
}
