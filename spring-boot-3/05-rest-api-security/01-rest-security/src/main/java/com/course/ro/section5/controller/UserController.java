package com.course.ro.section5.controller;

import com.course.ro.section5.model.dto.ChangePasswordDTO;
import com.course.ro.section5.model.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository repo;

//    @Autowired
//    private UserDetailsManager userDetailsManager;

    @GetMapping("/change-password")
    public String updatePassword(@RequestBody ChangePasswordDTO user){
//        System.out.println(user);
//        UserDetails orig = userDetailsManager.loadUserByUsername(user.getUsername());
//        userDetailsManager.changePassword(user.getOldPassword(), user.getNewPassword());
        return "success";
    }
}
