package com.microservices.authserver.services.impl;


import com.microservices.authserver.configs.JwtTokenProvider;
import com.microservices.authserver.dto.User_dto;
import com.microservices.authserver.repository.UsersRepository;
import com.microservices.authserver.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsersRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;


    @Override
    public String login(User_dto loginDto) {

        System.out.println(loginDto.getEmail());
        System.out.println(loginDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));


        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println(authentication.isAuthenticated());

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
}