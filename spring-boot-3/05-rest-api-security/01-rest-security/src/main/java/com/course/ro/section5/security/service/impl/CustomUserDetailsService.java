package com.course.ro.section5.security.service.impl;

import com.course.ro.section5.model.entity.User;
import com.course.ro.section5.model.repository.IUserRepository;
import com.course.ro.section5.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements IUserService {

    private final IUserRepository userRepo;

    @Autowired
    public CustomUserDetailsService(IUserRepository userRepo) {
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
