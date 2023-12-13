package com.microservices.authserver.repository;

import com.microservices.authserver.entity.Messages;

import com.microservices.authserver.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {

    List<Messages> findAllByUsers(Users user);

}
