package com.microservices.authserver.controllers;



import com.microservices.authserver.dto.JWTAuthResponse;
import com.microservices.authserver.dto.Msg;
import com.microservices.authserver.dto.Register_dto;
import com.microservices.authserver.dto.User_dto;
import com.microservices.authserver.entity.Users;
import com.microservices.authserver.services.AuthService;
import com.microservices.authserver.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/auth")
public class MainController {



    @Autowired
    UsersService usersService;
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody User_dto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        System.out.println(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<Msg> Register(@RequestBody Register_dto register_dto){
        System.out.println(register_dto.getEmail());
        System.out.println(register_dto.getUsername());
        String result = usersService.addUser(new Users(null, register_dto.getEmail(), register_dto.getPassword(), register_dto.getUsername()), register_dto.getRePassword());
        String responseMessage = "New user registered!" + result;
        Msg message = new Msg();
        message.setMsg(responseMessage);
        return ResponseEntity.ok(message);
    }


}
