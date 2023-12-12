package com.microservices.ownersserver.dto;


public class Owners_dto {

    private Long id;
    private String ownerName;
    private String dateOfBirth; // Изменили тип на String
    private String address;
    private String cellNumber;
    private Long user_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Owners_dto() {
    }

    public Owners_dto(Long id, String ownerName, String dateOfBirth, String address, String cellNumber, Long user_id) {
        this.id = id;
        this.ownerName = ownerName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.cellNumber = cellNumber;
        this.user_id = user_id;
    }
}
