package com.microservices.authserver.controllers;


import com.microservices.authserver.dto.Msg;
import com.microservices.authserver.dto.UpdatePassword;
import com.microservices.authserver.entity.Messages;
import com.microservices.authserver.entity.Users;
import com.microservices.authserver.repository.UsersRepository;
import com.microservices.authserver.services.MessagesService;
import com.microservices.authserver.services.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    MessagesService messagesService;

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
    public ResponseEntity<Msg> updatePassword(@RequestBody UpdatePassword updatePassword){
        String result = usersService.updatePassword(updatePassword.getPassword(), updatePassword.getNewPassword(), updatePassword.getReNewPassword());
        Msg message =  new Msg("Password updated" + result);
        return ResponseEntity.ok(message);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/getAllMessages")
    public ResponseEntity<List<Messages>> getMessages(){

        List<Messages> msgs = messagesService.getMessages(usersService.getCurrentUser());
        return ResponseEntity.ok(msgs);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/carBooking")
    public ResponseEntity<Msg> carBooking(){
        Msg message =  new Msg("");

        try{
            String result = messagesService.addMessage(new Messages(null, "Booking Car", "You have successfully booked a car, we ask you to come to our nearest administration service in the near future (we strongly recommend it), for example, tomorrow for further registration of the car.", java.sql.Date.valueOf(LocalDate.now()), "Administration", usersService.getCurrentUser()));
            message.setMsg(result);

        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(message);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/becomeLandlord")
    public ResponseEntity<Msg> becomeLandlord(){
        Msg message =  new Msg("");

        try{

            String result = messagesService.addMessage(new Messages(null, "Become a Partner", "Thank you for requesting to become a landlord.  We appreciate your trust. For further registration to become our partner, we ask you to come to the nearest point of administration of our service.", java.sql.Date.valueOf(LocalDate.now()), "Administration", usersService.getCurrentUser()));
            message.setMsg(result);

        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(message);
    }



}