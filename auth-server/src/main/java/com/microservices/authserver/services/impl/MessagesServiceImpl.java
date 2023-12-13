package com.microservices.authserver.services.impl;

import com.microservices.authserver.entity.Messages;
import com.microservices.authserver.entity.Users;
import com.microservices.authserver.repository.MessagesRepository;
import com.microservices.authserver.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    MessagesRepository messagesRepository;

    @Override
    public String addMessage(Messages messages) {
        messagesRepository.save(messages);
        return "success";
    }

    @Override
    public List<Messages> getMessages(Users user) {
        return messagesRepository.findAllByUsers(user);
    }

    @Override
    public Messages getMessage(Long id) {
        return messagesRepository.getReferenceById(id);
    }

    @Override
    public void deleteMessage(Messages message) {
        messagesRepository.delete(message);
    }

    @Override
    public Messages saveMessage(Messages message) {
        return messagesRepository.save(message);
    }
}
