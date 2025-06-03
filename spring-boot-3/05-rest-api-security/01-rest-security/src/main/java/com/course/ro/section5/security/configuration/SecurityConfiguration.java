package com.course.ro.section5.security.configuration;

import com.course.ro.section5.model.repository.IUserRepository;
import com.course.ro.section5.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private IUserRepository userRepo;

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
////        System.out.println("TESTING:::::::::::::::::::::::::::::" + userRepo.findAll().get(0));
//        return new InMemoryUserDetailsManager(
//                userRepo.findAll().stream().map(user -> {
//                    return User.builder()
//                            .username(user.getUsername())
//                            .password(user.getPassword())
//                            .roles(user.getRole().split(","))
//                            .build();
//                }).collect(Collectors.toList())
//        );
//    }


//    @Bean
//    public UserDetailsManager userDetailsService(DataSource ds) {
//    //        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
//    //        JdbcUserDetailsManager manager =
//
//        return new JdbcUserDetailsManager(ds);
//    }

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//        manager.setUsersByUsernameQuery("select username, password, enabled from user where username=?");
//        manager.setAuthoritiesByUsernameQuery("select username, concat('ROLE_', role) from user where username=?");
//        manager.setChangePasswordSql("update user set password = ? where username = ?");
//        return manager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("ldap", new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
        encoders.put("MD4", new org.springframework.security.crypto.password.Md4PasswordEncoder());
        encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_5());
        encoders.put("scrypt", SCryptPasswordEncoder.defaultsForSpringSecurity_v4_1());
        encoders.put("scrypt@SpringSecurity_v5_8", SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8());
        encoders.put("SHA-1", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-1"));
        encoders.put("SHA-256", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
        encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());
        encoders.put("argon2", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_2());
        encoders.put("argon2@SpringSecurity_v5_8", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8());
        return new DelegatingPasswordEncoder("noop", encoders);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(IUserService userService){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider(userService);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(conf -> conf
                .requestMatchers(HttpMethod.GET, "/companies").hasAnyRole("ADMIN", "USER", "SECURITY")
                .requestMatchers(HttpMethod.GET, "/companies/**").hasAnyRole("ADMIN", "USER", "SECURITY")
                .requestMatchers(HttpMethod.POST, "/companies").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/companies/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/companies/**").hasAnyRole("ADMIN", "SECURITY")
                .requestMatchers("/users").hasAnyRole("SECURITY")
                .requestMatchers("/users/**").hasAnyRole("SECURITY")
                .anyRequest().hasRole("SYSTEM")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }




}
