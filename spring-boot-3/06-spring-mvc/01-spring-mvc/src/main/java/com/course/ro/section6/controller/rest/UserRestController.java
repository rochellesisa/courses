package com.course.ro.section6.controller.rest;

import com.course.ro.section6.model.dto.ChangePasswordDTO;
import com.course.ro.section6.model.dao.spring.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRestController {

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
