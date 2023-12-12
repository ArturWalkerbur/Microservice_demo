package com.microservices.ownersserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "date_of_brith")
    private Date dateOfBrith;

    @Column(name = "address")
    private String address;

    @Column(name = "cell_number")
    private String cellNumber;

    @Column(name = "user_id")
    private Long user_id;


}
