package com.microservices.authserver.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message_dto {


    private Long id;

    private String topic;

    private String text;

    private String dateDispatch;

    private String sender;

}
