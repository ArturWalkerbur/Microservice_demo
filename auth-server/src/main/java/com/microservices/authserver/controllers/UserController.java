package com.microservices.authserver.controllers;


import com.microservices.authserver.dto.UpdatePassword;
import com.microservices.authserver.entity.Users;
import com.microservices.authserver.repository.UsersRepository;
import com.microservices.authserver.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

    /*@PreAuthorize("isAuthenticated()")
    @GetMapping("/info")
    public Boolean getUserDetails(){
        System.out.println("/info");
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }*/

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/getUser")
    public Users getUser(){
        return usersService.getCurrentUser();
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/update-password")
    public String updatePassword(@RequestBody UpdatePassword updatePassword){
        String result = usersService.updatePassword(updatePassword.getPassword(), updatePassword.getNewPassword(), updatePassword.getReNewPassword());
        return "Password updated" + result;

    }


}