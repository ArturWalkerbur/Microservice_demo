package com.microservices.authserver.services;


import com.microservices.authserver.dto.User_dto;

public interface AuthService {
    String login(User_dto loginDto);
}
