package com.microservices.ownersserver.dto;

public class Ownership_dto {

    private Long id;
    private Long car_id;
    private Long owner_id;
    private String ownershipStartDate;
    private String ownershipEndDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwnershipStartDate() {
        return ownershipStartDate;
    }

    public void setOwnershipStartDate(String ownershipStartDate) {
        this.ownershipStartDate = ownershipStartDate;
    }

    public String getOwnershipEndDate() {
        return ownershipEndDate;
    }

    public void setOwnershipEndDate(String ownershipEndDate) {
        this.ownershipEndDate = ownershipEndDate;
    }

    public Ownership_dto() {
    }

    public Ownership_dto(Long id, Long car_id, Long owner_id, String ownershipStartDate, String ownershipEndDate) {
        this.id = id;
        this.car_id = car_id;
        this.owner_id = owner_id;
        this.ownershipStartDate = ownershipStartDate;
        this.ownershipEndDate = ownershipEndDate;
    }
}
