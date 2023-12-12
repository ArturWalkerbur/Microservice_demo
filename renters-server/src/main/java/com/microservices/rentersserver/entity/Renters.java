package com.microservices.rentersserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "renters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Renters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "renter_name")
    private String renterName;

    @Column(name = "date_of_brith")
    private Date dateOfBrith;

    @Column(name = "address")
    private String address;

    @Column(name = "cell_number")
    private String cellNumber;

    @Column(name = "trusted_cell_number")
    private String trustedCellNumber;

    @Column(name = "iin")
    private String IIN;

    @Column(name = "user_id")
    private Long user_id;

}

