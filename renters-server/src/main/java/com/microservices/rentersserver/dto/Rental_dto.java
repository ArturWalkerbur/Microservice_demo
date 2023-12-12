package com.microservices.rentersserver.dto;

public class Rental_dto {

    private Long id;
    private Long car_id;
    private Long renter_id;
    private String rentalStartDate;
    private String rentalEndDate;

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

    public Long getRenter_id() {
        return renter_id;
    }

    public void setRenter_id(Long renter_id) {
        this.renter_id = renter_id;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(String renterStartDate) {
        this.rentalStartDate = renterStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(String renterEndDate) {
        this.rentalEndDate = renterEndDate;
    }

    public Rental_dto() {
    }

    public Rental_dto(Long id, Long car_id, Long renter_id, String renterStartDate, String renterEndDate) {
        this.id = id;
        this.car_id = car_id;
        this.renter_id = renter_id;
        this.rentalStartDate = renterStartDate;
        this.rentalEndDate = renterEndDate;
    }
}
