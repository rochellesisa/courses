package com.course.ro.section6.auth.service.impl;

import com.course.ro.section6.model.entity.User;
import com.course.ro.section6.model.dao.spring.IUserRepository;
import com.course.ro.section6.auth.service.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserAuthServiceImpl implements IUserAuthService {

    private final IUserRepository userRepo;

    @Autowired
    public UserAuthServiceImpl(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUser(username);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username or password");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getRoles(user));
    }

    private Collection<? extends GrantedAuthority> getRoles(User user){
        return user.getRolesAsList().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    }

    @Override
    public User findByUser(String username) {
        return userRepo.findByUsername(username);
    }


}
