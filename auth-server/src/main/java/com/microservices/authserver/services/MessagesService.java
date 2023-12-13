package com.microservices.authserver.services;

import com.microservices.authserver.entity.Messages;
import com.microservices.authserver.entity.Users;

import java.util.List;

public interface MessagesService {

    String addMessage(Messages messages);
    List<Messages> getMessages(Users currentUser);
    Messages getMessage(Long id);
    void deleteMessage(Messages message);
    Messages saveMessage(Messages message);
    
}
