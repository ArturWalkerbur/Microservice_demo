package com.microservices.ownersserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Table(name = "car_ownership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarOwnership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long car_id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Owners owner;

    @Column(name = "ownership_start_date")
    private Date ownershipStartDate;

    @Column(name = "ownership_end_date")
    private Date ownershipEndDate;



}

